class Solution {
    int n, k;
    int[] prices;
    Integer[][][] dp;
    public int maxProfit(int k, int[] prices) {
        this.n = prices.length;
        this.k = k;
        this.prices = prices;
        this.dp = new Integer[n][2][k];

        return dfs(0, 1, 0);
    }

    int dfs(int idx, int buy, int count) {
        if (idx == n || count == k) {
            return 0;
        }

        if (dp[idx][buy][count] != null) {
            return dp[idx][buy][count];
        }

        if (buy == 1) {
            int take = -prices[idx] + dfs(idx + 1, 1-buy, count);
            int dont = dfs(idx + 1, buy, count);
            return dp[idx][buy][count] = Math.max(take, dont);
        } else {
            int take = prices[idx] + dfs(idx + 1, 1-buy, count+1);
            int dont = dfs(idx + 1, buy, count);
            return dp[idx][buy][count] = Math.max(take, dont);
        }
    }
}