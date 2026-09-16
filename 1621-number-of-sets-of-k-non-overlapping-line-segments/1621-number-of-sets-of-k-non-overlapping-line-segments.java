class Solution {
    int n;
    Integer[][] dp;
    Integer[][] suffSum;
    int mod = (int)1e9 + 7;
    public int numberOfSets(int n, int k) {
        this.n = n;
        this.dp = new Integer[k+1][n+1];
        this.suffSum = new Integer[k+1][n+1];
        return dfs(k, 0);
    }

    int dfs(int k, int idx) {
        if (k == 0) {
            return 1;
        }

        if (idx >= n) {
            return 0;
        }

        if (dp[k][idx] != null) {
            return dp[k][idx];
        }

        int dont = dfs(k, idx + 1);

        int take = suffix(k - 1, idx + 1);

        return dp[k][idx] = (take + dont) % mod;
    }

    int suffix(int k, int idx) {
        if (idx >= n) {
            return 0;
        }

        if (suffSum[k][idx] != null) {
            return suffSum[k][idx];
        }

        return suffSum[k][idx] = (dfs(k, idx) + suffix(k, idx + 1)) % mod;
    }
}