class Solution {
    public int maxProfit(int[] prices) {
        int prof = 0, n = prices.length;
        
        for(int i = 1; i<n; i++){
            if(prices[i-1]<prices[i]){
                prof += prices[i]-prices[i-1];
            }
        }
            
        return prof;
    }
}