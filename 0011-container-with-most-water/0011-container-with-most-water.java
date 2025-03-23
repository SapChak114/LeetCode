class Solution {
    public int maxArea(int[] h) {
        int n = h.length;

        int l = 0, r = n-1, ans = 0;

        while (l <= r) {
            int vol = (r - l) * Math.min(h[r], h[l]);

            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }

            ans = Math.max(ans, vol);
        }

        return ans;
    }
}