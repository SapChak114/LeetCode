class Solution {
    int n;
    int[] coins;
    Integer[][] dp;
    int inf = (int)1e9 + 8;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.dp = new Integer[amount+1][coins.length+1];
        return dfs(amount, coins.length-1);
    }

    int dfs(int amount, int idx) {
        if (amount == 0) {
            return 1;
        }

        if (idx < 0) {
            return 0;
        }

        if (dp[amount][idx] != null) {
            return dp[amount][idx];
        }

        int take = 0;
        if (amount >= coins[idx]) { 
            take = dfs(amount - coins[idx], idx);
        }
        int dont = dfs(amount, idx - 1);

        return dp[amount][idx] = take + dont;
    }
}