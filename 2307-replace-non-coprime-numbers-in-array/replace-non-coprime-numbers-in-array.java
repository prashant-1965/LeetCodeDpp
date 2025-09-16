class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
            while (ans.size() > 1) {
                int a = ans.get(ans.size() - 1);
                int b = ans.get(ans.size() - 2);
                int g = gcd(a, b);
                if (g > 1) {
                    ans.remove(ans.size() - 1);
                    ans.remove(ans.size() - 1);
                    ans.add((a / g) * b);
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
