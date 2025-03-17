class Solution {
    int[] coins;
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.dp = new Integer[amount+1];
        int ans = dfs(amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int dfs(int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != null) {
            return dp[amount];
        }

        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int val = dfs(amount - coin);

            if (val != Integer.MAX_VALUE) {
                ans = Math.min(ans, val + 1);
            }
        }

        return dp[amount] = ans;
    }
}