class Solution {
    public int findLongestChain(int[][] pairs) {
        int count = 0, n = pairs.length, prev = Integer.MIN_VALUE;
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        
        for(int i = 0; i<n; i++){
            if(pairs[i][0]>prev){
                count++;
                prev = pairs[i][1];
            }
        }
        
        return count;
    }
}