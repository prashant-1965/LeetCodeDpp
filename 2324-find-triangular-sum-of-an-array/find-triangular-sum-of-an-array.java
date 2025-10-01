class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] nums_new = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            nums_new[i] = (nums[i] + nums[i+1]) % 10;
        }
        return triangularSum(nums_new);
    }

}