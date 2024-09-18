class Solution {
    int n, m;
    int[][] obs;
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] obs) {
        this.n = obs.length;
        this.m = obs[0].length;
        this.obs = obs;
        this.dp = new Integer[this.n][this.m];

        return unique(0, 0);
    }

    int unique(int i, int j) {
        if (i == n-1 && j == m-1 && obs[i][j] == 0) {
            return 1;
        }

        if (i >= n || j >= m || obs[i][j] == 1) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = unique(i+1, j) + unique(i, j+1);
    }
}