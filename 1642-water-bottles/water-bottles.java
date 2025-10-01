class Solution {
    public int numWaterBottles(int num1, int num2) {
        int cnt=0,mod,val;
        while(num1>=num2){
            val=(num1/num2);
            cnt+=val*num2;
            mod = num1%num2;
            num1=val+mod;
        }
        cnt+=num1;
        return cnt;
        
    }
}