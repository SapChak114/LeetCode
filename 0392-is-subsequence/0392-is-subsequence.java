class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        
        while(j<t.length() && i<s.length()){
            char a = s.charAt(i);
            char b = t.charAt(j);
            //System.out.println()
            if(a==b){
                i++;
                j++;
            }
            else if(a!=b){
                j++;
            }
        }
        
        if(i==s.length()) return true;
        else return false;
    }
}