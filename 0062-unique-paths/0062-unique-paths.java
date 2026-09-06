class Solution {
    int n, m;
    Integer[][] dp;
    public int uniquePaths(int n, int m) {
        this.n = n;
        this.m = m;
        this.dp = new Integer[n][m];
        return dfs(0, 0);
    }

    int dfs(int x, int y) {
        if (x == n-1 && y == m-1) {
            return 1;
        }

        if (x >= n || y >= m) {
            return 0;
        }

        if (dp[x][y] != null) {
            return dp[x][y];
        }

        int rightPath = 0;
        int downPath = 0;

        if (x < n-1) {
            rightPath = dfs(x + 1, y);
        }

        if (y < m-1) {
            downPath = dfs(x, y+1);
        }

        return dp[x][y] = rightPath + downPath;
    }
}