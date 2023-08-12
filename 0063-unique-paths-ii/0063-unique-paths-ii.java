class Solution {
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        dp = new Integer[grid.length+1][grid[0].length+1];
        return rec(grid,0,0);
    }
    
    int rec(int[][] grid, int i, int j){
        if(i==grid.length-1 && j==grid[0].length-1 && grid[i][j]!=1){
            return 1;
        }
        
        if(i>=grid.length || j>= grid[0].length || grid[i][j]==1){
            return 0;
        }
        
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        return dp[i][j] = rec(grid,i+1,j) + rec(grid,i,j+1);
    }
}