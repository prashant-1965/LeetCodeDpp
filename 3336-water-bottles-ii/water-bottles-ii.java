class Solution {
    public int maxBottlesDrunk(int num1, int num2) {
        int cnt=0,emp=0,full;
        while(num1>0){
            cnt+=num1;
            full=0;
            emp += num1;
            while(emp>=num2){
                emp-=num2;
                num2++;
                full++;
            }
            num1 = full;
        }
        cnt+=num1;
        return cnt;
    }
}