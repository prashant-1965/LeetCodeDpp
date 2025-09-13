class Solution {
    public int maxFreqSum(String s) {
        int[] track = new int[26];
        for(int i=0;i<s.length();i++)track[s.charAt(i)-'a']++;
        char[] ch = {'a','e','i','o','u'};
        int max1=0,max2=0;
        for(int i=0;i<5;i++){
            max1= Math.max(max1,track[ch[i]-'a']);
            track[ch[i]-'a'] = -1;
        }
        for(int i=0;i<26;i++)max2 = Math.max(max2,track[i]);
        return max1+max2;
    }
}