class Solution {
    Integer[] dp;
    int n;
    int[] nums;
    public int rob(int[] nums) {
        this.n = nums.length;
        this.dp = new Integer[n];
        this.nums = nums;
        return dfs(0);
    }

    int dfs(int i) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int take = nums[i] + dfs(i+2);
        int dont = dfs(i+1);

        return dp[i] = Math.max(take, dont);
    }
}