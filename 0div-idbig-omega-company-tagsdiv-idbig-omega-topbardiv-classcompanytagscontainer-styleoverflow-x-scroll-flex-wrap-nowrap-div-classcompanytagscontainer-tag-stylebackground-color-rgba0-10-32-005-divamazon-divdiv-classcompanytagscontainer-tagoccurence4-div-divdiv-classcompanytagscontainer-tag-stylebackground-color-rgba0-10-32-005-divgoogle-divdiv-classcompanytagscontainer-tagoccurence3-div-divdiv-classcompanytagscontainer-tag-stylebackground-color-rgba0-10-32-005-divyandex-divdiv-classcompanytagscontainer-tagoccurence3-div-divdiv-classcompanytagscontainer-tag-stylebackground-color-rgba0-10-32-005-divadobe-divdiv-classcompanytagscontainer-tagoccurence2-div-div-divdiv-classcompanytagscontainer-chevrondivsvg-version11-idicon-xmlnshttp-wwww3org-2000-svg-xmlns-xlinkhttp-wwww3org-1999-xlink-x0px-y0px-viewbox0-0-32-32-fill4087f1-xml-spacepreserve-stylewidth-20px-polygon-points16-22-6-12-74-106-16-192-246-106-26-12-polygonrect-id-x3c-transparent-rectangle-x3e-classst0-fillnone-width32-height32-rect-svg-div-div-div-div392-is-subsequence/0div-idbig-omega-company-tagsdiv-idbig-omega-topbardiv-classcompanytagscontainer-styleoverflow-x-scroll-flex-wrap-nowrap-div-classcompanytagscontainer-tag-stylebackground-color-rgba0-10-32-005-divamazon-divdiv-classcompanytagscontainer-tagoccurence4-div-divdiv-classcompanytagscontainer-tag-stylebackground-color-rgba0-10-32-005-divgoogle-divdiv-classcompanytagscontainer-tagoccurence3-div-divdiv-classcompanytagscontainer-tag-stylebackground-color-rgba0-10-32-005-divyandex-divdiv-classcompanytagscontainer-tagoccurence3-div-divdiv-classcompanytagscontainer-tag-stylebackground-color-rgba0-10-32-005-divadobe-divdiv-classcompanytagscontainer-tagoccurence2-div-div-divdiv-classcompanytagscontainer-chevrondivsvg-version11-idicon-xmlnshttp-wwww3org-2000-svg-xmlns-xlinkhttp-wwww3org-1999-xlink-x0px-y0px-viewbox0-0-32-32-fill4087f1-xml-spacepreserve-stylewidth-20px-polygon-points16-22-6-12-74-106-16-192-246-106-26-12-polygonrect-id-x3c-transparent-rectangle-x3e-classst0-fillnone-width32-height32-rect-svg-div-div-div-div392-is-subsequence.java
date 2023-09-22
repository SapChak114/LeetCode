class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        
        while(i<s.length() && j<t.length()){
            char a = s.charAt(i);
            char b = t.charAt(j);
            
            if(a==b){
                i++;
                j++;
            }
            else j++;
        }
        
        return i==s.length();
    }
}