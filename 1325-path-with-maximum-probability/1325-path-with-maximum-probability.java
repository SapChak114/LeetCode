class Pair{
    int v;
    double w;

    public Pair(int v, double w) {
        this.v = v;
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

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.w, a.w));
        double[] maxProb = new double[n];
        pq.add(new Pair(start_node, 1.0));
        maxProb[start_node] = 1d;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int path = p.v;
            double w = p.w;

            if (path == end_node) {
                return w;
            }

            for (Pair pp : adjList[path]) {
                if (pp.w * w > maxProb[pp.v]) {
                    maxProb[pp.v] = pp.w * w;
                    pq.add(new Pair(pp.v, maxProb[pp.v]));
                }
            }
        }

        return 0d;
    }
}