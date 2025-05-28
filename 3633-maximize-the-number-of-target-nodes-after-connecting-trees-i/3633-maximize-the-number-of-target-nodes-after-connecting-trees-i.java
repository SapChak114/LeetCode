class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<Integer> list1 = findCount(edges1, k);
        List<Integer> list2 = findCount(edges2, k-1);
        int maxElement = Collections.max(list2);

        int[] res = new int[list1.size()];

        for (int i = 0; i<res.length; i++) {
            res[i] = list1.get(i) + maxElement;
        }

        return res;
    }

    List<Integer> findCount(int[][] edges, int d) {
        int n = edges.length + 1;

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

        List<Integer> nodeCounts = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            nodeCounts.add(bfs(i, adjList, d, n));
        }

        return nodeCounts;
    }

    int bfs(int node, List<Integer>[] adjList, int distance, int n) {
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(node, 0));
        boolean[] vis = new boolean[n];
        vis[node] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int currNode = (int)p.getKey();
            int currNodeDistance = (int)p.getValue();

            if (currNodeDistance > distance) {
                continue;
            }

            count++;
            for (int newNode : adjList[currNode]) {
                if (!vis[newNode]) {
                    vis[newNode] = true;
                    queue.add(new Pair(newNode, currNodeDistance + 1));
                }
            }
        }
        
        return count;
    }
}