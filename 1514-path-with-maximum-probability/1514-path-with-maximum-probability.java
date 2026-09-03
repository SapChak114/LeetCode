class Pair {
    int node;
    double w;

    public Pair(int node, double w) {
        this.node = node;
        this.w = w;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<Pair>[] adjList = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adjList[u].add(new Pair(v, w));
            adjList[v].add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.w,a.w));
        pq.add(new Pair(start_node, 1D));

        double[] maxProb = new double[n];

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            double weight = p.w;

            for (Pair nei : adjList[node]) {
                if (weight * nei.w > maxProb[nei.node]) {
                    maxProb[nei.node] = weight * nei.w;
                    pq.add(new Pair(nei.node, maxProb[nei.node]));
                }
            }
        }

        return maxProb[end_node];
    }
}