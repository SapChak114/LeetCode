class Solution {
    public int maxArea(int[] h) {
        int n = h.length;

        int l = 0, r = n-1, res = 0;

        while (l < r) {
            int min = Math.min(h[l], h[r]);
            res = Math.max(res, (r-l) * min);

            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}