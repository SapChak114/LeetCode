class Solution {
    int row;
    int col;
    int[][] cells;
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.cells = cells;
        this.row=row;
        this.col=col;
        
        int left = 1, right = cells.length;
        int mid;
        int ans = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            //System.out.println(mid);
            if(canCross(mid)){
                ans = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    boolean canCross(int day){
        int[][] grid = new int[row][col];
        
        for(int i = 0; i<day; i++){
            grid[cells[i][0]-1][cells[i][1]-1]=1;
        }
        
        for(int i = 0; i<col; i++){
            if(grid[0][i]==0 && dfs(grid,0,i)){
                return true;
            }
        }
        
        return false;
    }
    
    boolean dfs(int[][] grid, int r, int c){
        if(r==row-1){
            return true;
        }
        
        grid[r][c]=-1;
        
        for(int i = 0; i<dirX.length; i++){
            int x = r + dirX[i];
            int y = c + dirY[i];
            if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!=0) continue;
            if(dfs(grid,x,y)) return true;
        }
        
        return false;
    }
}