class Solution {
    public int maxArea(int[] nums) {
        int low=0,fast = nums.length-1,ans=0,len,wid;
        while(low<fast){
            len = fast-low;
            wid = Math.min(nums[low],nums[fast]);
            ans=  Math.max(ans,len*wid);
            if(nums[fast]<nums[low])fast--;
            else low++;
        }
        return ans;
    }
}