class ShopPricing{
    public int shop;
    public int pricing;
    public int movie;
    public ShopPricing(int shop, int pricing){
        this.shop = shop;
        this.pricing = pricing;
    }
    public ShopPricing(int shop, int pricing, int movie){
        this.shop = shop;
        this.pricing = pricing;
        this.movie = movie;
    }
}
class MovieRentingSystem {
    public TreeSet<ShopPricing>[] set;
    public HashMap<Integer,ShopPricing>[] mapNums;
    
    public TreeSet<ShopPricing> tree;
    public TreeSet<ShopPricing> dropSet;
    public HashMap<Integer,ShopPricing> map;
    private HashMap<String, ShopPricing> dropMap;

    public ShopPricing val;


    public MovieRentingSystem(int n, int[][] nums) {
        set = new TreeSet[10001];
        mapNums = new HashMap[10001];
        map = new HashMap<>();
        dropMap = new HashMap<>();
        dropSet = new TreeSet<ShopPricing>((a,b)->{
            int c1 = Integer.compare(a.pricing,b.pricing);
            int c2 = Integer.compare(a.shop,b.shop);
            int c3 = Integer.compare(a.movie,b.movie);
            if(c1==0 && c2 ==0) return c3;
            if(c1==0) return c2;
            return c1;
        });
        for(int i=0;i<nums.length;i++){
            if(set[nums[i][1]]==null) set[nums[i][1]] = new TreeSet<>((a,b) -> {
                if (a.pricing != b.pricing) return a.pricing - b.pricing;
                    return a.shop - b.shop;
                }
            );
            if(mapNums[nums[i][1]]==null) mapNums[nums[i][1]] = new HashMap<>();
            map = mapNums[nums[i][1]];
            tree = set[nums[i][1]];
            val = new ShopPricing(nums[i][0],nums[i][2]);
            tree.add(val);
            map.put(nums[i][0],val);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> top = new ArrayList<>();
        if (set[movie] == null) return top;

        Iterator<ShopPricing> it = set[movie].iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            top.add(it.next().shop);
            count++;
        }
        return top;
    }

    
    public void rent(int shop, int movie) {
        String key = shop + "@" + movie;
        ShopPricing val = mapNums[movie].get(shop);
        ShopPricing temp = new ShopPricing(shop, val.pricing, movie);
        dropSet.add(temp);
        dropMap.put(key, temp);
        set[movie].remove(val);
        mapNums[movie].remove(shop);
    }

    
    public void drop(int shop, int movie) {
        String key = shop + "@" + movie;
        ShopPricing sp = dropMap.get(key);
        ShopPricing val = new ShopPricing(shop, sp.pricing);
        set[movie].add(val);
        mapNums[movie].put(shop, val);
        dropSet.remove(sp);
        dropMap.remove(key);
    }

    
    public List<List<Integer>> report() {
        List<List<Integer>> top = new ArrayList<>();
        int count = 0;
        for (ShopPricing sp : dropSet) {
            if (count >= 5) break;
            List<Integer> lt = new ArrayList<>();
            lt.add(sp.shop);
            lt.add(sp.movie);
            top.add(lt);
            count++;
        }
        return top;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */