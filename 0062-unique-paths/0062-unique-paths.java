class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m+1][n+1];
        return rec(0,0,m,n);
    }
    
    int rec(int i, int j, int m, int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        
        if(i>=m || j>=n){
            return 0;
        }
        
        if(dp[i][j]!=null) return dp[i][j];
        
        return dp[i][j] = rec(i+1,j,m,n) + rec(i,j+1,m,n);
    }
}