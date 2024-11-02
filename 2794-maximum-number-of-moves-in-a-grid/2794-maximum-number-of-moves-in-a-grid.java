class Solution {
    int[][] moves = {{-1, 1},{0, 1}, {1, 1}};
    int[][] grid;
    Integer[][] dp;
    public int maxMoves(int[][] grid) {
        this.grid = grid;
        int n = grid.length, m = grid[0].length;
        int max = 0;
        this.dp = new Integer[n][m];
        
        for (int i = 0; i<n; i++) {
            max = Math.max(max, dfs(i, 0));
        }

        return max;
    }

    int dfs(int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int maxMoves = 0;
        for (int a = 0; a<moves.length; a++) {
            int x = i + moves[a][0];
            int y = j + moves[a][1];
            if (check(i, j, x, y)) {
                maxMoves = Math.max(maxMoves, 1 + dfs(x, y));
            }
        }

        return dp[i][j] = maxMoves;
    }

    boolean check(int a, int b, int c, int d) {
        if (c < 0 || c >= grid.length || d < 0 || d >= grid[0].length || grid[a][b] >= grid[c][d]) {
            return false;
        }
        return true;
    }
}