class Solution {
    int[] cost;
    int n;
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        this.dp = new Integer[cost.length+1];
        this.cost=cost;
        this.n=cost.length;
        return Math.min(rec(0),rec(1));
    }
    
    int rec(int i){
        if(i==n-1){
            return cost[i];
        }
        if(i==n){
            return 0;
        }
        if(dp[i]!=null) return dp[i];
        
        return dp[i] = cost[i] + Math.min(rec(i+1),rec(i+2));
        
    }
}