class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet<>();
        for (char c : s.toCharArray()) {
            letters.add(c);
        }

        int total = 0;
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

            Set<Character> middle = new HashSet<>();
            for (int k = i+1; k<j; k++) {
                middle.add(s.charAt(k));
            }

            total += middle.size();
        }

        return total;
    }
}