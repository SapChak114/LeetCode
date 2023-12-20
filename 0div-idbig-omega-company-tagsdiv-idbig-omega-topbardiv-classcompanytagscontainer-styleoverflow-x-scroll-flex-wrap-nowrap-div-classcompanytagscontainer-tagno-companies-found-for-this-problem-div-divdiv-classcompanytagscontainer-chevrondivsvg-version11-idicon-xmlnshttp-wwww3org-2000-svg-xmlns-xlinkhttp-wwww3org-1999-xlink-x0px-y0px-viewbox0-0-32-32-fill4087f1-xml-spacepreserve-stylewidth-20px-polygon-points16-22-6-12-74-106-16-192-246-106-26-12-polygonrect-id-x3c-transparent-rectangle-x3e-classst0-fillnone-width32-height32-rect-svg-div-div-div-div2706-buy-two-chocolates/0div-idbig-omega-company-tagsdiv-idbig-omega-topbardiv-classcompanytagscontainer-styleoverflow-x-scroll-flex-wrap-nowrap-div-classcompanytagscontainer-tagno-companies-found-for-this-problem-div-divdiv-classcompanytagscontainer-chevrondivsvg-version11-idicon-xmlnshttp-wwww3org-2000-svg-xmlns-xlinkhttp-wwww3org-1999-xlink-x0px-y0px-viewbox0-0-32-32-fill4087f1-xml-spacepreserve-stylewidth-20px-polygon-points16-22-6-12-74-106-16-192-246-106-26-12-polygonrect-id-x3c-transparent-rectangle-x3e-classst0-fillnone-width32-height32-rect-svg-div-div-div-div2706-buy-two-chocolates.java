class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE, n = prices.length;
        int secondMin = Integer.MAX_VALUE-1;
        
        for(int i = 0; i<n; i++){
            if(prices[i]<min){
                secondMin = min;
                min = prices[i];
            }
            else if(prices[i]<secondMin){
                secondMin = prices[i];
            }
        }
        
        System.out.println(min+"  "+secondMin);
        int sum = min + secondMin;
        
        if(sum <= money) return money-sum;
        else return money;
    }
}