class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0], free = 0;
        
        for(int i = 1; i<n; i++){
            int tmp = hold;
            hold = Math.max(hold,free-prices[i]);
            free = Math.max(free,tmp+prices[i]-fee);
        }
        
        return free;
    }
}