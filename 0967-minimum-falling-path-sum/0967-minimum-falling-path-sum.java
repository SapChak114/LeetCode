class Solution {
    Integer[][] dp;
    int[][] matrix;
    int n, m;
    int inf = (int)1e9 + 7;
    public int minFallingPathSum(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;

        this.dp = new Integer[n+1][m+1];
        this.matrix = matrix;

        int ans = inf;
        for (int c = 0; c<m; c++) {
            ans = Math.min(ans, dfs(0, c));
        }

        return ans;
    }

    int dfs(int r, int c) {
        if (r == n) {
            return 0;
        }
        if (c < 0 || c == m) {
            return inf;
        }
        if (dp[r][c] != null) {
            return dp[r][c];
        }

        return dp[r][c] = matrix[r][c] + Math.min(dfs(r + 1, c - 1), Math.min(dfs(r + 1, c), dfs(r + 1, c + 1)));
    }
}