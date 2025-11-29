class Solution {
    int[] values;
    int res;
    int k;
    List<Integer>[] adjList;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.res = 0;
        this.k = k;
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        this.adjList = adjList;

        dfs(0, -1);

        return this.res;
    }

    long dfs(int cur, int par) {
        long total = values[cur];

        for (int child : adjList[cur]) {
            if (child != par) {
                total += dfs(child, cur);
            }
        }

        if (total % k == 0) {
            res++;
        }

        return total;
    }
}