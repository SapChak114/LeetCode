class Solution {
    int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dirY = {1, 1, 0, -1, -1, -1, 0, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        q.add(new int[]{0, 0, 1});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] currPos = q.poll();

            if (currPos[0] == n-1 && currPos[1] == m-1) {
                return currPos[2];
            }

            for (int d = 0; d < dirX.length; d++) {
                int newX = dirX[d] + currPos[0];
                int newY = dirY[d] + currPos[1];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m || vis[newX][newY] || grid[newX][newY] == 1) {
                    continue;
                }

                vis[newX][newY] = true;
                q.add(new int[]{newX, newY, currPos[2]+1});
            }
        }

        return -1;
    }
}