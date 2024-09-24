class Solution {
    Integer[][] dp;
    int n, m;
    int[][] grid;
    public int minPathSum(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.dp = new Integer[this.n][this.m];
        this.grid = grid;

        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if (j == m - 1 && i == n - 1) {
            return grid[i][j];
        }
        if (i >= n || j>= m) {
            return (int)1e9 + 7;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = Math.min(dfs(i+1, j), dfs(i, j + 1)) + grid[i][j];
    }
}