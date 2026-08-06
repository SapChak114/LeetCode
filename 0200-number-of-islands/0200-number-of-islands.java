class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    int n,m;
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        int count = 0;

        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(vis, i, j);
                    count++;
                }
            }
        }

        return count;
    }


    void dfs(boolean[][] vis, int x, int y) {
        vis[x][y] = true;

        for (int i = 0; i<4; i++) {
            int newx = dirX[i] + x;
            int newy = dirY[i] + y;

            if (newx < 0 || newx >= n || newy < 0 || newy >= m || grid[newx][newy] == '0' || vis[newx][newy]) {
                continue;
            }

            dfs(vis, newx, newy);
        }
    }
}