class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int l = 0, r = n-1, maxOfMin = Integer.MIN_VALUE, ans = 0;

        while (l < r) {
            int min = Math.min(h[l], h[r]);

            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }

            maxOfMin = Math.max(maxOfMin, min);
            ans += maxOfMin - min;
        }

        return ans;
    }
}