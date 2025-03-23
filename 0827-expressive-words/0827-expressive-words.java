class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;

        for (String word : words) {
            if (check(s, word)) {
                ans++;
            }
        }

        return ans;
    }

    boolean check(String s, String word) {
        int i = 0, j = 0, n = s.length(), m = word.length();

        while (i < n && j < m) {
            
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }

            int len1 = getLen(i, s);
            int len2 = getLen(j, word);

            if ((len1 < len2) || (len1 < 3 && len1 != len2)) {
                return false;
            }

            i += len1;
            j += len2;
        }

        return i == n && j == m;
    }

    int getLen(int i, String s) {
        int start = i, n = s.length();

        while (i < n && s.charAt(i) == s.charAt(start)) {
            i++;
        }

        return i - start;
    }
}