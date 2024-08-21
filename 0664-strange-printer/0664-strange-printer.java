class Solution {
    Integer[][] dp;
    String s;
    int n;
    public int strangePrinter(String s) {
        this.n = s.length();
        this.s = s;
        this.dp = new Integer[n][n];
        return dfs(0, n-1);
    }

    int dfs(int i, int j) {
        if (i == j) {
            return 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k<j; k++) {
            min = Math.min(min, dfs(i, k) + dfs(k+1, j));
        }

        return dp[i][j] = (s.charAt(i) == s.charAt(j)) ? min - 1 : min;
    }
}