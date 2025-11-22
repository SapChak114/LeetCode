class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i<s.length(); i++) {
            letters.add(s.charAt(i));
        }


        int ans = 0;
        for (char letter : letters) {
            int i = -1;
            int j = 0;

            for (int k = 0; k<s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) {
                        i = k;
                    }

                    j = k;
                }
            }

            Set<Character> btwn = new HashSet<>();
            for (int k = i+1; k<j; k++) {
                btwn.add(s.charAt(k));
            }

            ans += btwn.size();
        }

        return ans;
    }
}