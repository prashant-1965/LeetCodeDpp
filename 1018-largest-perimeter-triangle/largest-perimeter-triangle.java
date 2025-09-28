class Solution {
    public int largestPerimeter(int[] nums) {
        int ans=0,a,b,c;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            a = nums[i-2]; b = nums[i-1]; c = nums[i];
            if (a + b > c) {
                return a + b + c;
            }
        }
        return 0;
    }
    
}