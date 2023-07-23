class Solution {
    int length;
    public int longestCycle(int[] edges) {
        this.length=Integer.MIN_VALUE;
        int n = edges.length;
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i = 0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<n; i++){
            int u = i;
            int v = edges[i];
            if(v==-1) continue;
            adjList[u].add(v);
        }
        
        int[] vis = new int[n];
        
        for(int i = 0; i<n; i++){
            if(vis[i]==0)dfs(adjList,vis,i,1);
        }
        
        return length==Integer.MIN_VALUE?-1:length;       
    }
    
    void dfs(List<Integer>[] adjList, int[] vis, int node, int level){
        vis[node] = level;
        
        for(int n : adjList[node]){
            if(vis[n]==0){
                dfs(adjList,vis,n,level+1);
            }
            else if(vis[n]==-1) continue;
            else{
                int l = vis[n];
                length = Math.max(length,level-l+1);
            }
        }
        
        vis[node] = -1;
    }
}