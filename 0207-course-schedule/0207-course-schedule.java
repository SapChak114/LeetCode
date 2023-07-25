class Solution {
    public boolean canFinish(int num, int[][] pre) {
        List<Integer>[] adjList = new ArrayList[num];
        int[] vis = new int[num];
        
        for(int i = 0; i<num; i++) adjList[i] = new ArrayList<>();
        
        for(int i = 0; i<pre.length; i++){
            int u = pre[i][0];
            int v = pre[i][1];
            
            adjList[u].add(v);
        }
        
        for(int i = 0; i<num; i++){
            if(vis[i]==0){
                if(dfs(vis,adjList,i)) return false;
            }
        }
        
        return true;
        
    }
    
    boolean dfs(int[] vis, List<Integer>[] adjList, int node){
        vis[node] = 1;
        
        for(int n : adjList[node]){
            if(vis[n]==0){
                if(dfs(vis,adjList,n)) return true;
            }
            else if(vis[n]==1) return true;
        }
        
        vis[node] = 2;
        
        return false;
    }
}