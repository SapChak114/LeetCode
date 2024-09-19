class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";


        for (int i = 0; i<strs[0].length(); i++) {
            for (String st : strs) {
                if (i == st.length() || st.charAt(i) != strs[0].charAt(i)) {
                    return res;
                }
            }

            res += strs[0].charAt(i);
        }

        return res;
    }
}