class Solution {
    public int minCost(String s, int[] cost) {
        int sum = 0, n = s.length();
        
        for(int i = 0; i<n; i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)){
                sum += Math.min(cost[i],cost[i-1]);
                cost[i] = Math.max(cost[i],cost[i-1]);
            }
        }
        
        return sum;
    }
}