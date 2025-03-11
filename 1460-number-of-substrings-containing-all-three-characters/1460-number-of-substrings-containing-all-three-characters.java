class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), left = 0, right = 0, ans = 0;
        int[] freq = new int[3];

        while (right < n) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += (n - right);
                freq[s.charAt(left++) - 'a']--;
            }

            right++;
        }

        return ans;
    }
}