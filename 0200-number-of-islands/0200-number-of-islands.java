class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(vis, grid, i, j);
                }
            }
        }

        return count;
    }

    void dfs(boolean[][] vis, char[][] grid, int i, int j) {
        vis[i][j] = true;

        for (int a = 0; a<dirX.length; a++) {
            int newX = i + dirX[a];
            int newY = j + dirY[a];
            if (check(grid, vis, newX, newY)) {
                dfs(vis, grid, newX, newY);
            }
        }
    }

    boolean check(char[][] grid, boolean[][] vis, int a, int b) {
        return a>=0 && a<grid.length && b>=0 && b<grid[0].length && !vis[a][b] && grid[a][b] == '1';
    }
}