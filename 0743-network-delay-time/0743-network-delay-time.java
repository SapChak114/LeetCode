class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adjList = new ArrayList[n+1];
        int[] dist = new int[n+1];
        Set<Integer> seen = new HashSet<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for (int i = 0; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adjList[u].add(new int[]{v, w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] vals = pq.poll();
            int node = vals[0];
            int weight = vals[1];

            if (seen.contains(node)) {
                continue;
            }
            seen.add(node);

            for (int[] nei : adjList[node]) {
                int newNode = nei[0];
                int newWeight = nei[1];

                if (weight + newWeight < dist[newNode] && !seen.contains(newNode)) {
                    dist[newNode] = weight + newWeight;
                    pq.add(new int[]{newNode, dist[newNode]});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int  i = 1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}