class Solution {
    int k, n;
    int[] prices;
    Integer[][][] dp;
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.k = k;
        this.n = prices.length;
        this.dp = new Integer[prices.length][2][k+1];
        return rec(0, 1, 0);
    }

    int rec(int i, int buy, int count) {
        if (prices.length == i || count == k) {
            return 0;
        }

        if (dp[i][buy][count] != null) {
            return dp[i][buy][count];
        }

        if (buy == 1) {
            int take = -prices[i] + rec(i+1, 1-buy, count);
            int dont = rec(i+1, buy, count);
            return dp[i][buy][count] = Math.max(take, dont);
        } else {
            int take = prices[i] + rec(i+1, 1-buy, count + 1);
            int dont = rec(i+1, buy, count);
            return dp[i][buy][count] = Math.max(take, dont);
        }
    }
}