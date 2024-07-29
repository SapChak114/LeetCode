class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adjList = new ArrayList[n+1];

        for (int i = 0; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        List<Set<Integer>> dist = new ArrayList<>();
        for (int i = 0; i<=n; i++) {
            dist.add(new HashSet<>());
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        
        dist.get(1).add(0);

        while (!q.isEmpty()) {
            int[] val = q.poll();
            int node = val[0];
            int t = val[1];
            int qt = t/change;

            if (node == n && dist.get(node).size() == 2) {
                return Collections.max(dist.get(node));
            }

            if ((qt&1) == 1) {
                t = (qt+1)*change;
            }

            for (int nod : adjList[node]) {

                if (dist.get(nod).size() > 1) {
                    continue;
                }

                dist.get(nod).add(t+time);
                q.add(new int[]{nod, t+time});
            }
        }

        return -1;

    }
}