class Solution {
    public int maxProfit(int[] p) {
        int max = 0, maxSoFar = 0, n = p.length;
        
        for(int i = 1; i<n; i++){
            max = Math.max(0,max+p[i]-p[i-1]);
            maxSoFar = Math.max(maxSoFar,max);
        }
        
        return maxSoFar;
    }
}