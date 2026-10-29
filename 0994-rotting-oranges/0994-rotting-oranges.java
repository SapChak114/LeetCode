class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int nCount = 0, max = 0;
        boolean[][] vis = new boolean[n][m];
        while (!q.isEmpty()) {
            int[] data = q.poll();
            int x = data[0];
            int y = data[1];
            int t = data[2];

            max = Math.max(max, t);

            for (int i = 0; i<4; i++) {
                int newX = dirX[i] + x;
                int newY = dirY[i] + y;

                if (newX < 0 || newX >= n || newY < 0 || newY >= m || vis[newX][newY] || grid[newX][newY] != 1) {
                    continue;
                }

                q.add(new int[]{newX, newY, t + 1});
                vis[newX][newY] = true;
                nCount++;
            }
        }

        if (nCount != count) {
            return -1;
        }

        return max;
    }
}