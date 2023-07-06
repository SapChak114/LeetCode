class Solution {
    public int strStr(String haystack, String needle) {
        char[] ch1 = haystack.toCharArray();
        char[] ch2 = needle.toCharArray();
        
        int n = needle.length();
        int h = haystack.length();
        
        for(int i = 0; i<h-n+1; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(haystack.substring(i,n+i).equals(needle)){
                    return i;
                }
            }
        }
            
        return -1;
    }
}