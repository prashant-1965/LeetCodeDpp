class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] track = new int[101];
        int max=0;
        for(int i:nums){
            track[i]++;
            max = Math.max(max,track[i]);
        }
        // System.out.println(max);
        int ans=0;
        for(int i:track){
            if(i==max)ans+=i;
        }
        return ans;
    }
}