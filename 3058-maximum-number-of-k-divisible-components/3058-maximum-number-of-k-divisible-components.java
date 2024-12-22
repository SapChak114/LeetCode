class Solution {
    int n;
    int k;
    List<Integer>[] adjList;
    int[] values;
    int ans;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.n = n;
        this.k = k;
        this.values = values;
        this.adjList = new ArrayList[n];
        this.ans = 0;

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(0, -1);
        return ans;
    }

    int dfs(int u, int p) {
        int uVal = values[u];

        for (int v : adjList[u]) {
            if (v == p) {
                continue;
            }

            uVal += dfs(v, u);
        }

        if (uVal % k == 0) {
            ans++;
        }

        return uVal % k;
    }
}