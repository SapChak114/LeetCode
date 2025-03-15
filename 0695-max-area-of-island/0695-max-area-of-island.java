class Solution {
    int[][] grid;
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    boolean[][] vis;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxSize = 0;
        this.grid = grid;
        this.vis = new boolean[n][m];

        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int size = dfs(i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }

    int dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) {
            return 0;
        }
        
        vis[i][j] = true;
        int size = 1;
        for (int a = 0; a<X.length; a++) {
            int r = i + X[a];
            int c = j + Y[a];
            size += dfs(r, c);
        }

        return size;
    }
}