class Solution {
    public int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length, max = 0, ans = 0, left = 0;

        int[] chars = new int[26];

        for (int right = 0; right<n; right++) {
            chars[ch[right] - 'A']++;

            max = Math.max(max, chars[ch[right] - 'A']);

            while (right - left - max + 1 > k && left < n) {
                chars[ch[left++] - 'A']--;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}