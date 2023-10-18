class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int[] edge : relations){
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
            indegree[y]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n];

        for(int node = 0; node < n; node++){
            if(indegree[node] == 0){
                queue.add(node);
                maxTime[node] = time[node];
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : graph.get(node)){
                maxTime[neighbour] = Math.max(maxTime[neighbour], maxTime[node] + time[neighbour]);
                if(--indegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }
        int ans = Arrays.stream(maxTime).max().getAsInt();
        return ans;
    }
}