class Solution {
    public int[] findOrder(int nc, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[nc];
        for (int i = 0; i<nc; i++) {
            adjList[i] = new ArrayList<>();
        }
        int[] inDeg = new int[nc];

        for (int i = 0; i<pre.length; i++) {
            int course = pre[i][0];
            int preCourse = pre[i][1];

            adjList[preCourse].add(course);

            inDeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i<nc; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int nei : adjList[node]) {
                inDeg[nei]--;

                if (inDeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (order.size() < nc) {
            return new int[]{};
        }

        int[] arr = new int[nc];
        for (int i = 0; i<nc; i++) {
            arr[i] = order.get(i);
        }
        return arr;
    }
}