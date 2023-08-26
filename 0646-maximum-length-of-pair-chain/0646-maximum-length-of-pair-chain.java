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
/*
[[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]
[[-9,8],[-6,-2],[-6,9],[-5,3],[-1,4],[0,3],[1,6],[8,10]]
[[-6,-2],[-5,3],[0,3],[-1,4],[1,6],[-9,8],[-6,9],[8,10]]
*/