class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;

        int prev = nums[0], ans = -1;
        for (int i = 1; i<n; i++) {
            if (nums[i] > prev) {
                ans = Math.max(ans, nums[i] - prev);
            } else {
                prev = nums[i];
            }
        }

        return ans;
    }
}