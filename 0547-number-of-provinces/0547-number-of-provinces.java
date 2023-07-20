class Solution {
    public int findCircleNum(int[][] con) {
        int n = con.length;
        
        boolean[] vis = new boolean[n];
        
        int count = 0;
        
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                count++;
                dfs(con,vis,i);
            }
        }
        
        return count;
    }
    
    void dfs(int[][] con, boolean[] vis, int node){
        int n = con.length;
        vis[node] = true;
        
        for(int i = 0; i<n; i++){
            if(con[node][i]==1 && !vis[i]){
                dfs(con,vis,i);
            }
        }
    }
}