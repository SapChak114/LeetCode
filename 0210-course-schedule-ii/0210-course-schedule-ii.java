class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        
        List<Integer>[] adjList = new ArrayList[numCourses];
        
        for(int i = 0; i<numCourses; i++) adjList[i] = new ArrayList<>();
        
        for(int i = 0; i<pre.length; i++){
            int u = pre[i][0];
            int v = pre[i][1];
            
            adjList[u].add(v);
        }
        
        if(checkCycle(adjList)){
            return new int[]{};
        }
        
        boolean[] vis = new boolean[numCourses];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            if(!vis[i]){
                dfs(i,vis,adjList,ans);
            }
        }
        
        int[] res = new int[ans.size()];
        
        for(int i = 0; i<res.length; i++){
            res[i] = ans.get(i);
        }
        
        return res;
    }
    
    void dfs(int node, boolean[] vis, List<Integer>[] adjList, List<Integer> ans){
        
        vis[node] = true;
        
        for(int n : adjList[node]){
            if(!vis[n]){
                dfs(n,vis,adjList,ans);
            }
        }
        
        ans.add(node);
    }
    
    boolean checkCycle(List<Integer>[] adjList){
        int[] vis = new int[adjList.length];
        
        for(int i = 0; i<adjList.length; i++){
            if(vis[i]==0){
                if(dfsc(i,vis,adjList)) return true;
            }
        }
        
        return false;
    }
    
    boolean dfsc(int node, int[] vis, List<Integer>[] adjList){
        vis[node] = 1;
        
        for(int n : adjList[node]){
            if(vis[n]==0){
                if(dfsc(n,vis,adjList)) return true;
            }
            else if(vis[n]==1){
                return true;
            }
        }
        
        vis[node] = 2;
        
        return false;
    }
}