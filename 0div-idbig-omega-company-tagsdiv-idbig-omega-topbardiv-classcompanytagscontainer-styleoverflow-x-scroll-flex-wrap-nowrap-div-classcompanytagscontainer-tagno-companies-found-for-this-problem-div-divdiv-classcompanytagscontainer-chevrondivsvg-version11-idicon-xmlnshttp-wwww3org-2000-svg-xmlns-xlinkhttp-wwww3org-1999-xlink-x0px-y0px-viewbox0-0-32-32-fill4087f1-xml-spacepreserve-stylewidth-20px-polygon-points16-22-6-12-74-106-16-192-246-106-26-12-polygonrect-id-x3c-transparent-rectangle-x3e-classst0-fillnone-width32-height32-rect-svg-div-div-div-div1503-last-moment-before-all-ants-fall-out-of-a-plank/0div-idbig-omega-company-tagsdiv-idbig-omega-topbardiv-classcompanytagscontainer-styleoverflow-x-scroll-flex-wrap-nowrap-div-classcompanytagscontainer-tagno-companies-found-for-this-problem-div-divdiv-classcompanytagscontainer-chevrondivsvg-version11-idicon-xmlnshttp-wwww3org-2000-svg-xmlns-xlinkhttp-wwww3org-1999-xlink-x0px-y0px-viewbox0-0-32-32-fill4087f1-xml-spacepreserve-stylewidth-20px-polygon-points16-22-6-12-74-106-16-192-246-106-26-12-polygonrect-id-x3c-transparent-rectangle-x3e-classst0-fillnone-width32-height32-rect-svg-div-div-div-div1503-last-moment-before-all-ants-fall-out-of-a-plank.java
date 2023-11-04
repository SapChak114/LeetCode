class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = Integer.MIN_VALUE;
        
        for(int l : left){
            max = Math.max(max,l);
        }
        
        for(int r : right){
            max = Math.max(max,n-r);
        }
        
        return max;
        
    }
}