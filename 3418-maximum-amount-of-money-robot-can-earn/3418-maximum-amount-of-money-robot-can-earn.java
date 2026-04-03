class Solution {
    int[][] coins;
    Integer[][][] dp;
    int n, m;
    int MIN = Integer.MIN_VALUE;
    public int maximumAmount(int[][] coins) {
        this.coins = coins;
        this.n = coins.length;
        this.m = coins[0].length;
        this.dp = new Integer[n][m][3];
        return rec(0, 0, 2);
    }

    int rec(int i, int j, int k) {
        if (i == n || j == m) {
            return MIN;
        }

        if (i == n-1 && j == m-1) {
            return (coins[i][j] < 0 && k > 0) ? 0 : coins[i][j];
        }

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        int coin = coins[i][j];
        int res = coin + Math.max(rec(i + 1, j, k), rec(i, j + 1, k));
        
        if (coin < 0 && k > 0) {
            int skip = Math.max(rec(i + 1, j, k - 1), rec(i, j + 1, k - 1));

            res = Math.max(res, skip);
        }

        return dp[i][j][k] = res;
    }
}