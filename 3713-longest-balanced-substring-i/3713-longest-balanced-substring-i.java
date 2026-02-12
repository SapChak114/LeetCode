class Solution {
    public int longestBalanced(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i<n; i++) {
            int[] chars = new int[26];
            for (int j = i; j<n; j++) {
                chars[s.charAt(j) - 'a']++;
                if (j - i + 1 > res && check(chars)) {
                    res = j - i + 1;
                }
            }
        }

        return res;
    }

    boolean check(int[] chars) {
        
        int alph = 0;
        for (int ch : chars) {
            if (ch == 0) {
                continue;
            } else if (alph == 0) {
                alph = ch;
            } else if (alph != ch) {
                return false;
            }
        }

        return true;
    }
}