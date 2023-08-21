class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String m = s + s;
        return m.substring(1,m.length() - 1).contains(s);   
    }
}