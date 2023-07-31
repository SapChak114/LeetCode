class Solution {
    public int maxProfit(int[] prices) {
        int b1 = Integer.MAX_VALUE, b2 = Integer.MAX_VALUE, s1 = 0, s2 = 0;
        
        for(int i = 0; i<prices.length; i++){
            b1 = Math.min(b1,prices[i]);
            s1 = Math.max(s1,prices[i]-b1);
            b2 = Math.min(b2,prices[i]-s1);
            s2 = Math.max(s2,prices[i]-b2);
        }
        
        return s2;
    }
}