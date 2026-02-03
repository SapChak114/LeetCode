class Solution {
    public boolean canFinish(int nc, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[nc];

        for (int i = 0; i<nc; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<pre.length; i++) {
            int u = pre[i][0];
            int v = pre[i][1];
            adjList[u].add(v);
        }

        int[] vis = new int[nc];
        for (int i = 0; i<nc; i++) {
            if (vis[i] == 0) {
                if (dfs(adjList, vis, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(List<Integer>[] adjList, int[] vis, int node) {
        vis[node] = 1;

        for (int nod : adjList[node]) {
            if (vis[nod] == 1) {
                return true;
            } else if (vis[nod] == 0) {
                if (dfs(adjList, vis, nod)) {
                    return true;
                }
            }
        }

        vis[node] = 2;
        return false;
    }
}