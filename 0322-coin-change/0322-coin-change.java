class Solution {
    int n;
    int[] coins;
    Integer[] dp;
    int inf;
    public int coinChange(int[] coins, int amount) {
        this.n = coins.length;
        this.coins = coins;
        this.dp = new Integer[amount + 1];
        this.inf = (int)1e9 + 8;
        int res = dfs(amount);

        return res == inf ? -1 : res;
    }

    int dfs(int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return inf;
        }

        if (dp[amount] != null) {
            return dp[amount];
        }

        int ans = inf;
        for (int coin : coins) {
            ans = Math.min(ans, 1 + dfs(amount - coin));
        }

        return dp[amount] = ans;
    }
}