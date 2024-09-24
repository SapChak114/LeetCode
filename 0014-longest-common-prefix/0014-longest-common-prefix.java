class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";

        for (int i = 0; i<strs[0].length(); i++) {
            for (String str : strs) {
                if (i == str.length() || strs[0].charAt(i) != str.charAt(i)) {
                    return res;
                }
            }

            res += strs[0].charAt(i);
        }

        return res;
    }
}