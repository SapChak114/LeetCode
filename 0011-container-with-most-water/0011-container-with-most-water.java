class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int l = 0, r = n-1, res = 0;

        while (l<=r) {
            int area = (r-l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}