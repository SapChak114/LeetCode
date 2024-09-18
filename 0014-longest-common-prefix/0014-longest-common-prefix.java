class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs[0].length();

        String res = "";
        for (int i = 0; i<strs[0].length(); i++) {
            for (String st : strs) {
                if (i == n-1 || st.charAt(i) != strs[0].charAt(i)) {
                    return res;
                }
            }
            res += strs[0].charAt(i);
        }

        return res;
    }
}