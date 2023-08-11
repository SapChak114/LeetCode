class Solution {
    int[] coins;
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length+1][amount+1];
        this.coins = coins;
        return dfs(0,amount);    
    }
    
    int dfs(int idx, int amount){
        if(amount<0){
            return 0;
        }
        
        if(idx==coins.length){
            if(amount==0){
                return 1;
            } else{
                return 0;
            }
        }
        if(dp[idx][amount]!=null) return dp[idx][amount];
        
        int take = dfs(idx,amount-coins[idx]);
        int dont = dfs(idx+1,amount);
        
        return dp[idx][amount] = take + dont;
            
    }
}