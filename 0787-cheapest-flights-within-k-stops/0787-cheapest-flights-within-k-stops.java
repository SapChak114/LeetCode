class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            adjList[u].add(new int[]{v, w});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        while (!q.isEmpty()) {
            int[] vals = q.poll();
            int node = vals[0];
            int weight = vals[1];
            int stops = vals[2];

            if (stops > k) {
                continue;
            }

            for (int[] nei : adjList[node]) {
                int newNode = nei[0];
                int newWeight = nei[1];
                
                if (dist[newNode] > weight + newWeight && stops <= k) {
                    dist[newNode] = weight + newWeight;
                    q.add(new int[]{newNode, dist[newNode], stops+1});
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}