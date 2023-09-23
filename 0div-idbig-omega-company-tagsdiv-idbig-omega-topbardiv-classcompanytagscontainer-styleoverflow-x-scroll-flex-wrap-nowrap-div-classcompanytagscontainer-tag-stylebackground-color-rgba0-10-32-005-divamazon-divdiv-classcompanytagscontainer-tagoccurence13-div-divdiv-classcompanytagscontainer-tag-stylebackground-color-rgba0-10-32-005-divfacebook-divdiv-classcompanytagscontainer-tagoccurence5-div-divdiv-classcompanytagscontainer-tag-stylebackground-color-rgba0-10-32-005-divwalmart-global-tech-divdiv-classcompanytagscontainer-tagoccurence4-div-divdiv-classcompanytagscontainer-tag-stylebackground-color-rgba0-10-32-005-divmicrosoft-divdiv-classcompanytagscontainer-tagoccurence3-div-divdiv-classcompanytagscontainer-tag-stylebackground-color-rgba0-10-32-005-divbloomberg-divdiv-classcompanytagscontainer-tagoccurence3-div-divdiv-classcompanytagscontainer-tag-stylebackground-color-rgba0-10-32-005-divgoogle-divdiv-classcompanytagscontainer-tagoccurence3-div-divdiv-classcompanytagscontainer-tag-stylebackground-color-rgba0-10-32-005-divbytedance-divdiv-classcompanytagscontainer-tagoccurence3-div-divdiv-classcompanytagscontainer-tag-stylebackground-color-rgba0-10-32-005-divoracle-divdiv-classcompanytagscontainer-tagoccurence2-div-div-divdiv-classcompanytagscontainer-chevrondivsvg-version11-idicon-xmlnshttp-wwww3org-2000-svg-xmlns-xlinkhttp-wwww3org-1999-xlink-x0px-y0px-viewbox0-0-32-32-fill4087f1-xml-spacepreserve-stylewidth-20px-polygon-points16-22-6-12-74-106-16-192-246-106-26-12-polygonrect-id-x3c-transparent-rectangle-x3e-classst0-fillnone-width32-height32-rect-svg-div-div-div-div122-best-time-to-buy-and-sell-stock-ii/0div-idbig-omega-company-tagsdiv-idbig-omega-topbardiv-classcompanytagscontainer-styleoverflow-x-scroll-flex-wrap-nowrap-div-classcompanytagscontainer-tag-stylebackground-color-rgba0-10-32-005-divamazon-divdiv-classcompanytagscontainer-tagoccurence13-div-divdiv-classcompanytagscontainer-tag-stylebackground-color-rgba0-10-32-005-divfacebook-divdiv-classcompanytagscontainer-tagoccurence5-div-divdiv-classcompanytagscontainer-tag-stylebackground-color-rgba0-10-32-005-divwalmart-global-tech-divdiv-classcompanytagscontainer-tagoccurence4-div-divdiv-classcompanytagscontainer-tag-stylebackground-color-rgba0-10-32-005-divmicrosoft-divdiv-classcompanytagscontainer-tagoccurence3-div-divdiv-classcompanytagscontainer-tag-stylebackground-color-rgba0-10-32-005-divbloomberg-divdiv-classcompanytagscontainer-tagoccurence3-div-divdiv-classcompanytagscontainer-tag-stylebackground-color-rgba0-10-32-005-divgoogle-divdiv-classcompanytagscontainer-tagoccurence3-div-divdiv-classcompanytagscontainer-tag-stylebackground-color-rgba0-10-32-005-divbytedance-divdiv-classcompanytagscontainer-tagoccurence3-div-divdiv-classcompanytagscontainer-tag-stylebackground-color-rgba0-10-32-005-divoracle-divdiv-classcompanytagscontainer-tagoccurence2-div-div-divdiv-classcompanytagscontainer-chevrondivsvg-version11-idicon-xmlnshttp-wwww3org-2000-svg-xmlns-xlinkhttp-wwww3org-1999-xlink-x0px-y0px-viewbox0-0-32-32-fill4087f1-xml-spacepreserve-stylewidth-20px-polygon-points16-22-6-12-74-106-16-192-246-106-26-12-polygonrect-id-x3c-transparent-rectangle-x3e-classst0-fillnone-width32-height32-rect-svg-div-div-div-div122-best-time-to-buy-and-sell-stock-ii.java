class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return rec(0,1,prices);
    }
    
    int rec(int idx, int buy, int[] prices){
        if(idx==prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null) return dp[idx][buy];
        
        int profit = 0;
        
        if(buy==1){
            profit = Math.max((-prices[idx] + rec(idx+1,0,prices)), rec(idx+1,1,prices));
        } else{
            profit = Math.max((prices[idx] + rec(idx+1,1,prices)), rec(idx+1,0,prices));
        }
        
        return dp[idx][buy] = profit;
    }
}