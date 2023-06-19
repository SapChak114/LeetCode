class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        int n = gain.length;
        for(int i = 0; i<n; i++){
            curr += gain[i];
            max = Math.max(max,curr);
        }
        
        return max;
        
    }
}