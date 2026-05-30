class Solution {
    public int[] findOrder(int nc, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[nc];

        for (int i = 0; i<nc; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] inDeg = new int[nc];
        for (int i = 0; i<pre.length; i++) {
            int preCourse = pre[i][1];
            int course = pre[i][0];

            adjList[preCourse].add(course);
            inDeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i<inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int nod : adjList[node]) {
                inDeg[nod]--;

                if (inDeg[nod] == 0) {
                    q.add(nod);
                }
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}