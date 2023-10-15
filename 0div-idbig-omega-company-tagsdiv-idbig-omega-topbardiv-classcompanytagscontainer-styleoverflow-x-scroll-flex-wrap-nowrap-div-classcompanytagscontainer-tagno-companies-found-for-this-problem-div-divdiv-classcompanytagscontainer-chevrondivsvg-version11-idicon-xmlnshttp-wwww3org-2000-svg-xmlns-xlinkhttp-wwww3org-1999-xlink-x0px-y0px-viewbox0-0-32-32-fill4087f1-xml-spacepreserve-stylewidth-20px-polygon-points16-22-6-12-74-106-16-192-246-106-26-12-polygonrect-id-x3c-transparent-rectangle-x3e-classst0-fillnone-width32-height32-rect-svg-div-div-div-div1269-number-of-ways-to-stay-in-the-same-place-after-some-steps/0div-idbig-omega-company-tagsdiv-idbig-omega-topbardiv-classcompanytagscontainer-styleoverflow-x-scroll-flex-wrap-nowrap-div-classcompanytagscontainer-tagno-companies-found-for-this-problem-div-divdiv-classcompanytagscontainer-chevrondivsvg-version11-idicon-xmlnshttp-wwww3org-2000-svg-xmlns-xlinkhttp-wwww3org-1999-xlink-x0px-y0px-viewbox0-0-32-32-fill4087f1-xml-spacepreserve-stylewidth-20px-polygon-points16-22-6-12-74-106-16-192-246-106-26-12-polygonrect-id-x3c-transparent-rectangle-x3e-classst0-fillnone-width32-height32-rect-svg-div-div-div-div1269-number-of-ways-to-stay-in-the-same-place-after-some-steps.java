class Solution {
    Integer[][] dp;
    int mod = (int)1e9 + 7;
    int len;
    public int numWays(int stp, int len) {
        len = Math.min(stp,len);
        this.len=len;
        dp = new Integer[len][stp+1];
        return rec(0,stp);
    }
    
    int rec(int curr, int rem){
        if(rem==0){
            if(curr==0){
                return 1;
            }
            return 0;
        }
        
        if(dp[curr][rem]!=null) return dp[curr][rem];
        
        int ans = rec(curr,rem-1);
        if(curr>0){
            ans = (ans + rec(curr-1,rem-1))%mod;
        }
        
        if(curr < len-1){
            ans = (ans + rec(curr+1, rem-1))%mod;
        }
        
        return dp[curr][rem] = ans;
    }
}