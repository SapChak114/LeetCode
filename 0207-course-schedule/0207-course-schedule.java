class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int n = pre.length;
        List<Integer>[] adjList = new ArrayList[numCourses];
        
        for(int i = 0; i<numCourses; i++) adjList[i] = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            int u = pre[i][0];
            int v = pre[i][1];
            
            adjList[u].add(v);
        }
        
        int[] vis = new int[numCourses];
        
        for(int i = 0; i<numCourses; i++){
            if(vis[i]==0 && dfs(vis,adjList,i)) return false;
        }
        
        return true;
    }
    
    boolean dfs(int[] vis, List<Integer>[] adjList, int node){
        vis[node]=1;
        
        for(int n : adjList[node]){
            if(vis[n]==1){
                return true;
            }
            else if(vis[n]==0 && dfs(vis,adjList,n)) return true;
        }
        
        vis[node] = 2;
        return false;
    }
}