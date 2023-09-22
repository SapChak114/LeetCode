class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    max = Math.max(max,dfs(grid,i,j));
                }
            }
        }
        
        return max;
    }
    
    int dfs(int[][] grid, int i, int j){
        grid[i][j]=0;
        
        int count = 1;
        for(int k = 0; k<dirX.length; k++){
            int r = i + dirX[k];
            int c = j + dirY[k];
            
            if(isValid(grid,r,c)){
                count += dfs(grid,r,c);
            }
        }
        return count;
    }
    
    boolean isValid(int[][] grid, int r, int c){
        int n = grid.length, m = grid[0].length;
        if(r<0 || r>=n || c<0 || c>=m || grid[r][c]!=1) return false;
        return true;
    }
}