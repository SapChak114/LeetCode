class Pair {
    int x;
    int y;
    int t;
    public Pair(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
class Solution {
    int[][] grid;
    boolean[][] vis;
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    int n, m;
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;

        this.grid = grid;
        this.vis = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int time = 0, nCount = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            time = Math.max(time, p.t);
            for (int i = 0; i<4; i++) {
                int newX = p.x + X[i];
                int newY = p.y + Y[i];
                if (!check(newX, newY)) {
                    continue;
                }
                vis[newX][newY] = true;
                q.add(new Pair(newX, newY, p.t+1));
                nCount++;
            }
        }

        if (nCount != count) {
            return -1;
        }

        return time;
    }

    private boolean check(int x, int y) {
        return x < n && y < m && x >= 0 && y >= 0 && grid[x][y] == 1 && !vis[x][y];
    }
}