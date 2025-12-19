class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]>[] adjList = new ArrayList[n];
        for(int i = 0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i<meetings.length; i++){
            int u = meetings[i][0];
            int v = meetings[i][1];
            int t = meetings[i][2];

            adjList[u].add(new int[]{t,v});
            adjList[v].add(new int[]{t,u});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});
        pq.add(new int[]{0,firstPerson});
        boolean[] seen = new boolean[n];
        while(!pq.isEmpty()){
            int[] ar = pq.poll();
            int time = ar[0];
            int node = ar[1];
            if(seen[node]){
                continue;
            }
            seen[node] = true;
            for(int[] nei : adjList[node]){
                int t = nei[0];
                int v = nei[1];
                if(t >= time && !seen[v]){
                    pq.add(new int[]{t,v});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(seen[i]){
                ans.add(i);
            }
        }

        return ans;
    }
}