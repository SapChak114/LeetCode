class Solution {
    int WHITE = 0, GREY = 1, BLACK = 2;
    public boolean canFinish(int nc, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[nc];

        for (int i = 0; i<nc; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<pre.length; i++) {
            int course = pre[i][0];
            int preCourse = pre[i][1];

            adjList[preCourse].add(course);
        }

        int[] vis = new int[nc];
        for (int i = 0; i<nc; i++) {
            if (vis[i] == WHITE && dfs(i, vis, adjList)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int node, int[] vis, List<Integer>[] adjList) {
        vis[node] = GREY;

        for (int nei : adjList[node]) {
            if (vis[nei] == WHITE) {
                if (dfs(nei, vis, adjList)) {
                    return true;
                }
            } else if (vis[nei] == GREY) {
                return true;
            }
        }

        vis[node] = BLACK;
        return false;
    }
}