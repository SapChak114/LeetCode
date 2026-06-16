class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> o1[0] - o2[0]);
        pq.add(new int[]{0, 0});

        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int mst = 0;
        while (!pq.isEmpty()) {
            int[] vals = pq.poll();
            int wt = vals[0];
            int u = vals[1];

            if (vis[u]) {
                continue;
            }

            vis[u] = true;
            mst += wt;

            for (int v = 0; v<n; v++) {

                if (!vis[v]) {
                    int manhattenDist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);

                    if(manhattenDist < dist[v]) {
                        dist[v] = manhattenDist;
                        pq.add(new int[]{manhattenDist, v});
                    }
                }
            }
        }

        return mst;
    }
}