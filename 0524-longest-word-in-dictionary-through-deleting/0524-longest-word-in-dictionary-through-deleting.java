class Solution {
    public String findLongestWord(String s, List<String> d) {
        String maxStr = "";

        for (String st : d) {
            if (isSubsequence(st, s) && (st.length() > maxStr.length() 
            || (st.length() == maxStr.length() && st.compareTo(maxStr) < 0))) {
                maxStr = st;
            }
        }

        return maxStr;
    }


    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length(), j = 0, i = 0;

        while(i<n && j<m){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else{
                j++;
            }
        }

        return i==n;
    }
}