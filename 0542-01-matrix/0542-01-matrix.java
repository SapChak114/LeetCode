class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();

        int n = mat.length, m = mat[0].length;
        int[][] dist = new int[n][m];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int steps = arr[2];
            dist[x][y] = steps;
            for (int i = 0; i<4; i++) {
                int r = x + X[i];
                int c = y + Y[i];

                if (r < n && r >= 0 && c < m && c >= 0 && mat[r][c] == 1) {
                    q.add(new int[]{r, c, steps + 1});                   
                    mat[r][c] = -1;
                }
            }
        }

        return dist;
    }
}