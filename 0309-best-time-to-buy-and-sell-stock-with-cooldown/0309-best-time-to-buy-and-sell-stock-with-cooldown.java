class Solution {
    int[] prices;
    Map<String, Integer> dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.prices = prices;
        this.dp = new HashMap<>();
        return dfs(0, true);
    }

    int dfs(int idx, boolean isBuy) {
        if (idx >= prices.length) {
            return 0;
        }

        String key = idx+"_"+isBuy;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (isBuy) {
            int buy = dfs(idx+1, !isBuy) - prices[idx];
            int coolDown = dfs(idx+1, isBuy);
            dp.put(key, Math.max(buy, coolDown));
            return Math.max(buy, coolDown);
        } else {
            int sell = dfs(idx+2, !isBuy) + prices[idx];
            int coolDown = dfs(idx+1, isBuy);

            dp.put(key, Math.max(sell, coolDown));
            return Math.max(sell, coolDown);
        }
    }
}