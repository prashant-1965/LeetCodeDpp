class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i=0,j=0,val1,val2;
        while(i<str1.length && j<str2.length){
            val1 = Integer.parseInt(str1[i]);
            val2 = Integer.parseInt(str2[j]);
            if(val1<val2) return -1;
            if(val1>val2) return 1;
            i++;
            j++;
        }
        while(i==str1.length && j<str2.length){
            val1=Integer.parseInt(str2[j]);
            if(val1!=0) return -1;
            j++;
        }
        while(j==str2.length && i<str1.length){
            val1=Integer.parseInt(str1[i]);
            if(val1!=0) return 1;
            i++;
        }
        return 0;
    }
}