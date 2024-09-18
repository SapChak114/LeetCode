class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        
        for (int a = 0; a<dirX.length; a++) {
            int newX = dirX[a] + i;
            int newY = dirY[a] + j;

            if (check(grid, newX, newY, vis)) {
                dfs(grid, newX, newY, vis);
            }
        }

    }

    boolean check(char[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || i>= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' || vis[i][j]) {
            return false;
        }
        return true;
    }
}