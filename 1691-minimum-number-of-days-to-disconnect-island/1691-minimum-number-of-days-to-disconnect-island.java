class Solution {
    int[][] grid;
    
    public int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        this.grid = grid;

        if (!isIsland()) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0; 
                    if (!isIsland()) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    boolean isIsland() {
        int n = grid.length, m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                    dfs(grid, vis, i, j);
                }
            }
        }

        return count == 1;
    }

    void dfs(int[][] mat, boolean[][] seen, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || seen[i][j] || mat[i][j] == 0) {
            return;
        }
        seen[i][j] = true;

        dfs(mat, seen, i + 1, j);  // down
        dfs(mat, seen, i - 1, j);  // up
        dfs(mat, seen, i, j + 1);  // right
        dfs(mat, seen, i, j - 1);  // left
    }
}
