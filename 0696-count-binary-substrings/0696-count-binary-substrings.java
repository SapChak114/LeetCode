class Solution {
    public int countBinarySubstrings(String s) {
        int curr = 1, prev = 0, n = s.length(), ans = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                curr++;
            } else {
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }

        return ans += Math.min(curr, prev);
    }
}