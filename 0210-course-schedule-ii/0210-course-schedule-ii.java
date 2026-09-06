class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];

        for (int i = 0; i<numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] inDeg = new int[numCourses];
        for (int i = 0; i<prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];

            adjList[pre].add(course);
            inDeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<numCourses; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> odering = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();

            odering.add(node);
            for (int nei : adjList[node]) {
                inDeg[nei]--;

                if (inDeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (odering.size() < numCourses) {
            return new int[]{};
        }

        int[] ans = new int[odering.size()];
        for (int i = 0; i<odering.size(); i++) {
            ans[i] = odering.get(i);
        }

        return ans;
    }
}