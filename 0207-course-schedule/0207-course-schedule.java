class Solution {
    int WHITE = 0, GREY = 1, BLACK = 2;
    public boolean canFinish(int nc, int[][] pre) {
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

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for (int nei : adjList[node]) {
                inDeg[nei]--;

                if (inDeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return count == nc;
    }
}