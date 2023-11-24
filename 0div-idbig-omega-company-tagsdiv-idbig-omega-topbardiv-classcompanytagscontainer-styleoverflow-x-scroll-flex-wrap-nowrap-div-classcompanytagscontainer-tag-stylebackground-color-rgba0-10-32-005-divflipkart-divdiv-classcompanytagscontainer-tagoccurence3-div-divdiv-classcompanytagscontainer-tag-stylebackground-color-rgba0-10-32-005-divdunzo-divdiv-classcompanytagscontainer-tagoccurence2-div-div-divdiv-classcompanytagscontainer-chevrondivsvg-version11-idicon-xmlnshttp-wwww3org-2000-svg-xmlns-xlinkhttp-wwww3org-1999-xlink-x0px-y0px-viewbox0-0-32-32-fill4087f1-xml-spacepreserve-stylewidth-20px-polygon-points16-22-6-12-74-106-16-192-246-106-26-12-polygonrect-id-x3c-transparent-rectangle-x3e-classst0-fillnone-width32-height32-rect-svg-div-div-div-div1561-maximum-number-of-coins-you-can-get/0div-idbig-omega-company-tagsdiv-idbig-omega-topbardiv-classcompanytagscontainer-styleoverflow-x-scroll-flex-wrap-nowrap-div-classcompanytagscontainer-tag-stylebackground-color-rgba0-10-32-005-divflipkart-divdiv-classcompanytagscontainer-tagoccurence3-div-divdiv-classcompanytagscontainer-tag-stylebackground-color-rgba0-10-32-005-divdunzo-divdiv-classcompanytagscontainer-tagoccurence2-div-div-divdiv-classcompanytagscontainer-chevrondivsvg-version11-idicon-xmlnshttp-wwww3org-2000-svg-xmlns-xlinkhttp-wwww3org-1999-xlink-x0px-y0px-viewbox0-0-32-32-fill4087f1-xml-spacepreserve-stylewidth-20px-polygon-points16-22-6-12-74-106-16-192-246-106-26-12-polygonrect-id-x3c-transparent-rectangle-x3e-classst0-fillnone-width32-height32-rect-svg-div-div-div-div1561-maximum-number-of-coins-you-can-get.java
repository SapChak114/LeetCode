class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        int n = piles.length;
        int i = n-2;
        int j = 0;
        while(j++ < n/3){
            sum += piles[i];
            i -= 2;
        }
        
        return sum;
    }
}