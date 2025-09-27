class Solution {
    public double largestTriangleArea(int[][] nums) {
        int x1,x2,x3,y1,y2,y3;
        double ans=Double.MIN_VALUE,temp;
        for(int i =0;i<nums.length;i++){
            x1 =nums[i][0]; y1=nums[i][1];
            for(int j=i+1;j<nums.length;j++){
                x2=nums[j][0]; y2=nums[j][1];
                for(int k=j+1;k<nums.length;k++){
                    x3=nums[k][0]; y3=nums[k][1];
                    temp =0.5*Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
                    ans = Math.max(ans,temp);
                }
            }
        }
        return ans;
    }
}