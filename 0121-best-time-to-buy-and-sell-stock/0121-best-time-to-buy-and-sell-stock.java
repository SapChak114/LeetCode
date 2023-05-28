class Solution {
    public int maxProfit(int[] prices) {
        //Kadane's Algo
        
        int max = 0;
        int maxSoFar = 0;
        
        for(int i = 1; i<prices.length; i++){
            max = Math.max(0,max += prices[i]-prices[i-1]);
            maxSoFar = Math.max(maxSoFar,max);
        }
        
        return maxSoFar;
    }
    
}