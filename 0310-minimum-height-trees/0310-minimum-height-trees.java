class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i<n; i++) {
            inDegree.put(i, 0);
        }

        int m = edges.length;
        for (int i = 0; i<m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

            inDegree.put(u, inDegree.get(u) + 1);
            inDegree.put(v, inDegree.get(v) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 1) {
                queue.add(e.getKey());
            }
        }

        int level = n;
        while (level > 2) {
            int size = queue.size();
            level -= queue.size();

            for (int i = 0; i<size; i++) {
                int leaf = queue.poll();

                for (int nei : graph.get(leaf)) {
                    inDegree.put(nei, inDegree.get(nei) - 1);
                    if (inDegree.get(nei) == 1) {
                        queue.add(nei);
                    }
                }
            }
        }

        return n > 2 ? new ArrayList<>(queue) : n == 1 ? Arrays.asList(0) : Arrays.asList(0, 1);
    }
}