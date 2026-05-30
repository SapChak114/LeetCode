class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    int max, count;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        this.max = Integer.MIN_VALUE;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    this.count = 0;
                    dfs(grid, vis, i, j);
                    this.max = Math.max(this.max, this.count);
                }
            }
        }

        return this.max == Integer.MIN_VALUE ? 0 : this.max;
    }

    void dfs(int[][] grid, boolean[][] vis, int i, int j) {
        vis[i][j] = true;
        this.count++;
        for (int a = 0; a<dirX.length; a++) {
            int newX = i + dirX[a];
            int newY = j + dirY[a];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1 && !vis[newX][newY]) {
                dfs(grid, vis, newX, newY);
            }
        }
    }
}