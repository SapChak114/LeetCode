class Solution {
    public int possibleStringCount(String word) {
        char[] ch = word.toCharArray();
        int n = ch.length, ans = 1;

        for (int i = 1; i<n; i++) {
            if (ch[i] == ch[i-1]) {
                ans++;
            }
        }

        return ans;
    }
}