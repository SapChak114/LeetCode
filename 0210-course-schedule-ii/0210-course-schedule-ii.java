class Solution {
    public int[] findOrder(int num, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[num];

        for (int i = 0; i<num; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<pre.length; i++) {
            for (int j = 0; j<pre[i].length; j++) {
                int u = pre[i][0];
                int v = pre[i][1];
                adjList[u].add(v);
            }
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
                dfs(adjList, seen, i, ans);
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

        for (int nod : adjList[node]) {
            if (vis[nod] == 0) {
                if (dfsCy(adjList, vis, nod)) {
                    return true;
                }
            } else if (vis[nod] == 1) {
                return true;
            }
        }

        vis[node] = 2;
        return false;
    }

    void dfs(List<Integer>[] adjList, Set<Integer> seen, int node, List<Integer> ans) {
        seen.add(node);

        for (int nod : adjList[node]) {
            if (!seen.contains(nod)) {
                dfs(adjList, seen, nod, ans);
            }
        }

        ans.add(node);
    }
}