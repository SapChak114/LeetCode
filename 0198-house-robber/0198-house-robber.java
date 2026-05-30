class Solution {
    Integer[] dp;
    int n;
    int[] nums;
    public int rob(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.dp = new Integer[this.n];

        return dfs(n-1);
    }

    int dfs(int n) {
        if (n < 0) {
            return 0;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        int take = nums[n] + dfs(n-2);
        int dont = dfs(n-1);

        return dp[n] = Math.max(take, dont);
    }
}