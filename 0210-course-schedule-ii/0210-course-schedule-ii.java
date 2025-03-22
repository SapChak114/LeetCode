class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i<numCourses; i++) {
            inDegree.put(i, 0);
        }

        
        List<Integer> order = new ArrayList<>();

        int n = pre.length;
        for (int i = 0; i<n; i++) {
            int course = pre[i][0];
            int preCourse = pre[i][1];
            graph.computeIfAbsent(preCourse, k -> new ArrayList<>()).add(course);
            
            inDegree.put(course, inDegree.get(course) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                queue.add(e.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            if (graph.containsKey(node)) {
                for (int nei : graph.get(node)) {
                    inDegree.put(nei, inDegree.get(nei) - 1);

                    if (inDegree.get(nei) == 0) {
                        queue.add(nei);
                    }
                }
            }
        }

        if (order.size() == numCourses) {
            return order.stream().mapToInt(i -> i).toArray();
        }

        return new int[]{};
    }
}