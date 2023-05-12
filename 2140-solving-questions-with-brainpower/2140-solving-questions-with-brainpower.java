class Solution {
    public long mostPoints(int[][] q) {
        long[] dp = new long[q.length+1];
        Arrays.fill(dp,-1);
        return brain(dp,q,0);
    }
    
    long brain(long[] dp, int[][] q, int i){
        if(i>=q.length) return 0l;
        
        if(dp[i]!=-1) return dp[i];
        
        return dp[i] = Math.max(q[i][0]+brain(dp,q,i+q[i][1]+1),brain(dp,q,i+1));
    }
}