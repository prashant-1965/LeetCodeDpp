class Solution {
    public int minimumTotal(List<List<Integer>> nums) {
        int[][] dp = new int[nums.size()][nums.get(nums.size()-1).size()];
        for(int i=0;i<dp[dp.length-1].length;i++)dp[dp.length-1][i] = nums.get(nums.size()-1).get(i);
        // for(int i=0;i<dp[dp.length-1].length;i++)System.out.print(dp[dp.length-1][i]+" ");

        for(int i=nums.size()-2;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                dp[i][j] = nums.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<nums.get(0).size();i++)ans = Math.min(ans,dp[0][i]);
        return ans;
    }
}