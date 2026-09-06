class Solution {
    int[] cost;
    Integer[] dp;
    int n;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.dp = new Integer[cost.length];
        this.n = cost.length;
        return Math.min(dfs(0), dfs(1));
    }

    int dfs(int idx) {
        if (idx == n-1) {
            return cost[idx];    
        }

        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        return dp[idx] = cost[idx] + Math.min(dfs(idx + 1), dfs(idx + 2));
    }
}