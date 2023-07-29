class Solution {
    int[] piles;
    Integer[][][] dp;
    public boolean stoneGame(int[] piles) {
        this.piles=piles;
        int n = piles.length;
        dp = new Integer[n+1][n+1][2];
        int alice = rec(0,n-1,true);
        
        int sum = 0;
        for(int p : piles){
            sum += p;
        }
        
        int bob = sum - alice;
        
        return alice>=bob;
    }
    
    int rec(int start, int end, boolean isAlice){
        if(start>end){
            return 0;
        }
        
        if(dp[start][end][isAlice?0:1]!=null) return dp[start][end][isAlice?0:1];
        
        if(isAlice){
            int fromStart = piles[start] + rec(start+1,end,false);
            int fromEnd = piles[end] + rec(start,end-1,false);
            
            return dp[start][end][0] = Math.max(fromStart,fromEnd);
        } else{
            
            int fromStart = rec(start+1,end,true);
            int fromEnd = rec(start,end-1,true);
            
            return dp[start][end][1] = Math.min(fromStart,fromEnd);
        }
    }
}