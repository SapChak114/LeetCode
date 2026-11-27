class Solution {
    Integer[][] dp;
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int m = items[0].length;
        int minPrice = Integer.MAX_VALUE;
        this.dp = new Integer[n+1][budget+1];
        
        int[] copies = new int[n];

        for (int i = 0; i<n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            int copy = 0;
            for (int j = 0; j<n; j++) {
                if (i == j) {
                    continue;
                }

                if (items[j][0] % items[i][0] == 0) {
                    copy++;
                }
            }

            copies[i] = copy;
        }


        return rec(n, items, budget, minPrice, copies);
    }

    int rec (int n, int[][] items, int budget, int minPrice, int[] copies) {
        if (n == 0) {
            return budget/minPrice;
        }
        
        if (dp[n][budget] != null) {
            return dp[n][budget];
        }

        int take = 0, price = items[n-1][1];

        if (price <= budget) {
            take = 1 + copies[n-1] + rec(n-1, items, budget - price, minPrice, copies);
        }

        int dont = rec(n-1, items, budget, minPrice, copies);

        return dp[n][budget] = Math.max(take, dont);
    }
}