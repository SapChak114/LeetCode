class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    int[][] grid;
    int k, n, m;
    public int countIslands(int[][] grid, int k) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.k = k;

        boolean[][] vis = new boolean[n][m];

        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (!vis[i][j] && grid[i][j] != 0) {
                    vis[i][j] = true;
                    long sum = dfs(i, j, vis);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }


        return count;
    }

    long dfs(int i, int j, boolean[][] vis) {
        long sum = grid[i][j];
        for (int a = 0; a<4; a++) {
            int x = i + dirX[a];
            int y = j + dirY[a];

            if (!check(x, y, vis)) {
                continue;
            }

            vis[x][y] = true;
            sum += dfs(x, y, vis);
        }

        return sum;
    }

    boolean check(int x, int y, boolean[][] vis) {
        return x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && grid[x][y] != 0;
    }
}
/**
[
[0,0,0],
[0,0,1],
[11,0,6],
[0,10,2],
[0,0,0],
[8,0,0]
]

 */