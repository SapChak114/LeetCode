class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), left = 0, max = 0, res = 0;

        int[] ch = new int[26];
        for (int right = 0; right<n; right++) {
            char c = s.charAt(right);
            ch[c-'A']++;

            max = Math.max(max, ch[c-'A']);
            while (right - left + 1 - max > k) {
                ch[s.charAt(left++) - 'A']--;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}