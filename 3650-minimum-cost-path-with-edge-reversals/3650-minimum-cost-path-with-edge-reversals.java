class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, 2 * w});
        }

        int[] d = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            int u = data[0];
            int dist = data[1];

            if (u == n - 1) {
                return dist;
            }

            if (vis[u]) {
                continue;
            }

            vis[u] = true;

            for (int[] dat : adjList[u]) {
                int v = dat[0];
                int w = dat[1];

                if (dist + w < d[v]) {
                    d[v] = dist + w;
                    pq.add(new int[]{v, d[v]});
                }
            }
        }

        return -1;
    }
}