class Solution {
    Integer[][] dp;
    int n, m;
    int[][] matrix;
    public int minFallingPathSum(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.matrix = matrix;

        this.dp = new Integer[n][m];

        int ans = (int)1e9 + 7;
        for (int i = 0; i<m; i++) {
            ans = Math.min(ans, dfs(0, i));
        }

        return ans;
    }

    int dfs(int r, int c) {
        if (r == n) {
            return 0;
        }

        if (c < 0 || c == m) {
            return (int) 1e9 + 7;
        }

        if (dp[r][c] != null) {
            return dp[r][c];
        }

        return dp[r][c] = matrix[r][c] + Math.min(dfs(r + 1, c - 1), Math.min(dfs(r + 1, c), dfs(r + 1, c + 1)));
    }
}