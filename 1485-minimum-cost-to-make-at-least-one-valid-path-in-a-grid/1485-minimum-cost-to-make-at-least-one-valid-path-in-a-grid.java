class Solution {
    class Pair {
        int x, y, cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[][] dist = new int[m][n];
        
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (p.x == m - 1 && p.y == n - 1) {
                return p.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int newCost = p.cost + (grid[p.x][p.y] == i + 1 ? 0 : 1);

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && dist[nx][ny] > newCost) {
                    dist[nx][ny] = newCost;
                    pq.add(new Pair(nx, ny, newCost));
                }
            }
        }

        return -1; // Shouldn't reach here
    }
}
