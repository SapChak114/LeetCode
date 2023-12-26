class Solution {
    Integer[][] dp;
    int mod = (int)1e9 + 7;
    public int numRollsToTarget(int n, int k, int targ) {
        dp = new Integer[n+1][targ+1];
        return dfs(n,k,targ);
    }
    
    int dfs(int n, int k, int targ){
        if(n<0 || targ<0) return 0;
        if(n==0 && targ==0) return 1;
        if(dp[n][targ]!=null) return dp[n][targ];
        
        int totalWays = 0;
        for(int i=1; i<=k; i++){
            if(i<=targ) totalWays = (totalWays + dfs(n-1,k,targ-i))%mod;
        }
        
        return dp[n][targ] = totalWays;
        
    }
}