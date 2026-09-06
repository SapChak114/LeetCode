class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int max = 0, nCount = 0;
        while (!q.isEmpty()) {
            int[] vals = q.poll();
            int x = vals[0];
            int y = vals[1];
            int t = vals[2];

            max = Math.max(max, t);
            for (int i = 0; i<4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m || vis[newX][newY] || grid[newX][newY] != 1) {
                    continue;
                }

                vis[newX][newY] = true;
                q.add(new int[]{newX, newY, t + 1});
                nCount++;
            }
        }

        if (count == nCount) {
            return max;
        }

        return -1;
    }
}