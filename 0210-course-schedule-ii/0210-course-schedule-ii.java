class Solution {
    List<Integer> ans;
    public int[] findOrder(int num, int[][] pre) {
        ans = new ArrayList<>();
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
                if(dfs(vis,adjList,i)) return new int[]{};
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++){
            res[i]=ans.get(i);
        }
        
        return res;
    }
    
    boolean dfs(int[] vis, List<Integer>[] adjList, int node){
        vis[node] = 1;
        
        for(int n : adjList[node]){
            if(vis[n]==0){
                if(dfs(vis,adjList,n)) return true;
            }
            else if(vis[n]==1) return true;
        }
        ans.add(node);
        vis[node] = 2;
        
        return false;
    }
}