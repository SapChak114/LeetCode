class Solution {
    int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dirY = {1, 1, 0, -1, -1, -1, 0, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] vals = q.poll();
            int x = vals[0];
            int y = vals[1];
            int t = vals[2];

            if (x == n-1 && y == m-1) {
                return t;
            }

            for (int i = 0; i<dirX.length; i++) {
                
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == 1 || vis[newX][newY]) {
                    continue;
                }

                vis[newX][newY] = true;
                q.add(new int[]{newX, newY, t+1});
            }
        }

        return -1;
    }
}