class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int courseCount = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            courseCount++;
            for (int nei : adjList[node]) {
                inDeg[nei]--;

                if (inDeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return courseCount == numCourses;
    }
}