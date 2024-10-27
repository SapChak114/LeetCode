class Solution {
    Integer[][] dp;
    int[][] matrix;
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int squares = 0;

        this.dp = new Integer[n][m];
        this.matrix = matrix;

        for (int row = 0; row<n; row++) {
            for (int col = 0; col<m; col++) {
                squares += dfs(row, col);
            }
        }

        return squares;
    }

    int dfs(int row, int col) {
        if (row == matrix.length || col == matrix[0].length || matrix[row][col] == 0) {
            return 0;
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        return dp[row][col] = 1 + Math.min(dfs(row + 1, col), Math.min(dfs(row, col + 1), dfs(row + 1, col + 1)));
    }
}