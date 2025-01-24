class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];

        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<n; i++) {
            for (int node : graph[i]) {
                adjList[node].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int nei : adjList[node]) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i< n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}