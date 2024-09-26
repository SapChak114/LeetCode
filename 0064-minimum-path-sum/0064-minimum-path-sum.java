class Solution {
    Integer[][] dp;
    int[][] grid;
    int n, m;
    public int minPathSum(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.dp = new Integer[this.n][this.m];
        return rec(0, 0);
    }

    int rec(int i, int j) {
        if (i == n-1 && j == m-1) {
            return grid[i][j];
        }

        if (i >= n || j >= m) {
            return (int)1e9 + 7;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = Math.min(rec(i+1, j), rec(i, j + 1)) + grid[i][j];
    }
}