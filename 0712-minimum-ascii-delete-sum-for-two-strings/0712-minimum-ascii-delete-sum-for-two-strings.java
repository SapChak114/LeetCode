class Solution {
    String s1, s2;
    int n, m;
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        this.s1=s1;
        this.s2=s2;
        this.n=s1.length();
        this.m=s2.length();
        dp = new Integer[n+1][m+1];
        return rec(0,0);
    }
    
    int rec(int i, int j){
        if(i>=n && j>=m){
            return 0;
        }
        
        if(i>=n){
            int c = s2.charAt(j);
            return c + rec(i,j+1);
        }
        
        if(j>=m){
            int c = s1.charAt(i);
            return c + rec(i+1,j);
        }
        
        if(dp[i][j]!=null) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)){
            return rec(i+1,j+1);
        }
        
        
        
        int del1 = (int)s1.charAt(i) + rec(i+1,j);
        int del2 = (int)s2.charAt(j) + rec(i,j+1);
        
        return dp[i][j]=Math.min(del1,del2);
    }
}