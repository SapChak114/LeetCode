class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp = new Integer[n+1];
        return rec(n,n);
    }
    
    int rec(int n, int idx){
        if(idx==0 || idx==1){
            return 1;
        }
        if(dp[idx]!=null) return dp[idx];
        
        return dp[idx] = rec(n,idx-2) + rec(n,idx-1);
    }
}