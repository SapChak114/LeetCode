class Solution {
    int[][] grid;
    Integer[][] dp;
    int n, m;
    public int minPathSum(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.dp = new Integer[n][m];
        return dfs(0, 0);
    }

    int dfs(int x, int y) {
        if (x == n-1 && y == m-1) {
            return grid[x][y];
        }

        if (x >= n || y >= m) {
            return (int)1e9+8;
        }

        if (dp[x][y] != null) {
            return dp[x][y];
        }

        return dp[x][y] = grid[x][y] + Math.min(dfs(x+1, y), dfs(x, y+1));
    }
}