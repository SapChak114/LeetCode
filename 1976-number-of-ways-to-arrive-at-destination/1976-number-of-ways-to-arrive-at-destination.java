class Pair{
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;
        List<Pair>[] adjList = new ArrayList[n];

        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int start = road[0], end = road[1], time = road[2];

            adjList[start].add(new Pair(end, time));
            adjList[end].add(new Pair(start, time));
        }


        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        int[] pathCount = new int[n];

        shortestTime[0] = 0;
        pathCount[0] = 1;

        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long currTime = top[0];
            int currNode = (int) top[1];

            if (currTime > shortestTime[currNode]) {
                continue;
            }

            for (Pair neigh : adjList[currNode]) {
                int neighNode = neigh.node;
                int roadTime = neigh.weight;

                if (currTime + roadTime < shortestTime[neighNode]) {
                    shortestTime[neighNode] = currTime + roadTime;
                    pathCount[neighNode] = pathCount[currNode];
                    pq.add(new long[]{shortestTime[neighNode], neighNode});
                } else if (currTime + roadTime == shortestTime[neighNode]) {
                    pathCount[neighNode] = (pathCount[neighNode] + pathCount[currNode]) % mod;
                }
            }
        }

        return pathCount[n-1];
    }
}