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
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    int[][] grid;
    boolean[][] vis;
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length, count = 0, time = 0;
        this.grid = grid;

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        this.vis = new boolean[n][m];

        int noCount = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            time = Math.max(time, pair.t);

            for (int i = 0; i<X.length; i++) {
                int r = pair.x + X[i];
                int c = pair.y + Y[i];

                if (check(r, c)) {
                    vis[r][c] = true;
                    queue.add(new Pair(r, c, pair.t+1));
                    noCount++;
                }
            }
        }

        if (noCount != count) {
            return -1;
        }

        return time;

    }

    boolean check(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !vis[r][c];
    }
}