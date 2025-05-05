class Solution {
    Integer[][] dp;
    int n;
    int MOD = (int) (1e9 + 7);
    public int numTilings(int n) {
        this.dp = new Integer[n+1][n+1];
        this.n = n;
        return rec(0, 0);
    }

    int rec(int i, int j) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            if (j == 0) return 1;
            else return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        long res;
        if (j == 0) {
            res = (rec(i + 1, 0) + rec(i + 2, 0)) % MOD;
            res = (res + 2L * rec(i + 1, 1)) % MOD;
        } else {
            res = (rec(i + 1, 1) + rec(i + 2, 0)) % MOD;
        }

        return dp[i][j] = (int) res;
    }
}