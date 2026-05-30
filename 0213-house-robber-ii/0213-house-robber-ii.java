class Solution {
    int n;
    int[] nums;
    Integer[] dp;
    public int rob(int[] nums) {
        this.n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        this.nums = nums;
        this.dp = new Integer[this.n];
        int ans1 = dfs(0, n-2);
        this.dp = new Integer[this.n];
        int ans2 = dfs(1, n-1);
        return Math.max(ans1, ans2);
    }

    int dfs(int start, int end) {
        if (start > end) {
            return 0;
        }

        if (dp[end] != null) {
            return dp[end];
        }

        int take = nums[end] + dfs(start, end - 2);
        int dont = dfs(start, end - 1);

        return dp[end] = Math.max(take, dont);
    }
}