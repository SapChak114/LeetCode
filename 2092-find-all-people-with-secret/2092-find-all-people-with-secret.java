class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int fp) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<meetings.length; i++) {
            int u = meetings[i][0];
            int v = meetings[i][1];
            int t = meetings[i][2];

            adjList[v].add(new int[]{u, t});
            adjList[u].add(new int[]{v, t});
        }

        boolean[] seen = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{0, 0});
        pq.add(new int[]{fp, 0});
    
        while (!pq.isEmpty()) {
            int[] nodes = pq.poll();
            int u = nodes[0];
            int time = nodes[1];
            
            if (seen[u]) {
                continue;
            }

            seen[u] = true;
            for (int[] nei : adjList[u]) {
                int v = nei[0];
                int t = nei[1];

                if (t >= time && !seen[v]) {
                    pq.add(new int[]{v, t});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i<seen.length; i++) {
            if (seen[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}