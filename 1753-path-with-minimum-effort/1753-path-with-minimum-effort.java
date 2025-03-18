class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] minEffort = new int[n][m];
        for (int[] me : minEffort) {
            Arrays.fill(me, Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int r = node[0], c = node[1], effort = node[2];

            if (r == n-1 && c == m-1) {
                return effort;
            }

            for (int i = 0; i<X.length; i++) {
                int nr = X[i] + r;
                int nc = Y[i] + c;

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int newEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));

                if (newEffort < minEffort[nr][nc]) {
                    minEffort[nr][nc] = newEffort;
                    pq.add(new int[]{nr, nc, newEffort});
                }
            }
        }

        return -1;
    }
}