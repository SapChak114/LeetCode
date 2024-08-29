class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        int numOfConnectedComponents = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i<n; i++) {
            if (!vis[i]) {
                dfs(adjList, vis, i);
                numOfConnectedComponents++;
            }
        }

        return n - numOfConnectedComponents;
    }

    void dfs(List<Integer>[] adjList, boolean[] vis, int stone) {
        vis[stone] = true;

        for (int neighbor : adjList[stone]) {
            if (!vis[neighbor]) {
                dfs(adjList, vis, neighbor);
            }
        }
    }
}