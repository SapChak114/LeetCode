class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int p = flights[i][2];

            adjList[u].add(new int[]{v, p});
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new int[]{0, src, 0});
        dist[src] = 0;

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int stops = pair[0];
            int node = pair[1];
            int cost = pair[2];

            if (stops > k) {
                continue;
            }

            for (int[] newPair : adjList[node]) {
                int newNode = newPair[0];
                int newCost = newPair[1];

                if (cost + newCost < dist[newNode] && stops <= k) {
                    dist[newNode] = cost + newCost;
                    q.add(new int[]{stops + 1, newNode, dist[newNode]});
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}