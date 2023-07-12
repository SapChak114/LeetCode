class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i]=new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            for(int x : graph[i]){
                inDegree[i]++;
                adj[x].add(i);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int p = q.poll();
            res.add(p);
            for(int x : adj[p]){
                if(--inDegree[x]==0){
                    q.add(x);
                }
            }
        }
        
        Collections.sort(res);
        return res;
    }
}