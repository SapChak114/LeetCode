class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    char[][] grid;
    int n,m;
    public int numIslands(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, vis);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int i, int j, boolean[][] vis) {
         for (int a = 0; a<dirX.length; a++) {
            int newX = i + dirX[a];
            int newY = j + dirY[a];

            if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == '0' || vis[newX][newY]) {
                continue;
            }

            vis[newX][newY] = true;
            dfs(newX, newY, vis);
         }
    }
}