class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return rec(1,0,prices);
    }
    
    int rec(int buy, int idx, int[] prices){
        if(idx==prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null) return dp[idx][buy];
        
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[idx] + rec(0,idx,prices),rec(1,idx+1,prices));
        } else{
            profit = Math.max(prices[idx]+rec(1,idx+1,prices),rec(0,idx+1,prices));
        }
        
        return dp[idx][buy]=profit;
    }
}