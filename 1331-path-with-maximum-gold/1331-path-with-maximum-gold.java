class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    int[][] grid;
    int n,m;
    public int getMaximumGold(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        int maxGold = 0;
        this.grid = grid;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(i, j));
                }
            }
        }

        return maxGold;
    }

    int dfs(int i, int j) {
        if (i < 0 || i>=n || j < 0 || j >= m || grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];
        grid[i][j] = 0;

        int max = 0;
        for (int a = 0; a<X.length; a++) {
            int r = i + X[a];
            int c = j + Y[a];
            max = Math.max(max, dfs(r, c));
        }

        grid[i][j] = gold;
        return gold + max;
    }
}