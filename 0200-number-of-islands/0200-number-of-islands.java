class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(vis,grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    void dfs(boolean[][] vis, char[][] grid, int i, int j){
        vis[i][j]=true;
        int n = grid.length, m = grid[0].length;
        for(int x = 0; x<dirX.length; x++){
                int newX = dirX[x] + i;
                int newY = dirY[x] + j;
                if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY]=='1' && !vis[newX][newY]){
                    dfs(vis,grid,newX,newY);
                }
        }
    }
}