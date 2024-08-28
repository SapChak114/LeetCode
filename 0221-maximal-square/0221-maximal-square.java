class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        int max = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, dfs(matrix, dp, i, j));
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max * max;
    }

    int dfs(char[][] matrix, int[][] dp, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (matrix[i][j] == '0') {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = dfs(matrix, dp, i+1, j);
        int right = dfs(matrix, dp, i, j+1);
        int diag = dfs(matrix, dp, i+1, j+1);

        return dp[i][j] = 1 + Math.min(down, Math.min(right, diag));
    }
}