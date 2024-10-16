class Solution {
    int n, m;
    int[][] grid;
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.dp = new Integer[this.n][this.m];

        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if (i == n-1 && j == m-1 && grid[i][j] == 0) {
            return 1;
        }
        if (i >= n || j >= m || grid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = dfs(i+1, j) + dfs(i, j+1);
    }
}