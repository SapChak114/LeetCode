class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length, ans = Integer.MIN_VALUE;

        for (int i = 1; i<n; i++) {
            ans = Math.max(ans, Math.abs(nums[i-1] - nums[i]));

            if (i == n-1) {
                ans = Math.max(ans, Math.abs(nums[i] - nums[0]));
            }
        }

        return ans;
    }
}