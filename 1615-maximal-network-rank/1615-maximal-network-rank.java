class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i = 0; i<n; i++) adjList[i] = new ArrayList<>();
        
        for(int i = 0; i<roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        int rank = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int directLink = adjList[i].contains(j)?1:0;
                rank = Math.max(rank,adjList[i].size()+adjList[j].size()-directLink);
            }
        }
        
        return rank;
    }
}