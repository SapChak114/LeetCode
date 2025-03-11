class Solution {
    public int[] findOrder(int num, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[num];

        for (int i = 0; i<num; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<pre.length; i++) {
            int u = pre[i][0];
            int v = pre[i][1];
            adjList[u].add(v);
        }

        int[] vis = new int[num];
        for (int i = 0; i<num; i++) {
            if (dfsCy(adjList, vis, i)) {
                return new int[]{};
            }
        }

        List<Integer> ans = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i<num; i++) {
            if (!seen.contains(i)) {
                dfs(seen, adjList, i, ans);
            }
        }

        int[] res = new int[ans.size()];

        for (int i = 0; i<res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    boolean dfsCy(List<Integer>[] adjList, int[] vis, int node) {
        vis[node] = 1;

        for (int n : adjList[node]) {
            if (vis[n] == 0) {
                if (dfsCy(adjList, vis, n)) {
                    return true;
                }
            } else if (vis[n] == 1) {
                return true;
            }
        }

        vis[node] = 2;
        return false;
    }

    void dfs(Set<Integer> seen, List<Integer>[] adjList, int node, List<Integer> ans) {
        seen.add(node);

        for (int nod : adjList[node]) {
            if (!seen.contains(nod)) {
                dfs(seen, adjList, nod, ans);
            }
        }

        ans.add(node);
    }


}