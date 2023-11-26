class Solution {
    public int largestSubmatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        
        for(int row = 0; row<n; row++){
            for(int col = 0; col<m; col++){
                if(mat[row][col]!=0 && row>0){
                    mat[row][col] += mat[row-1][col];
                }
            }
            
            int[] newRow = mat[row].clone();
            Arrays.sort(newRow);
            for(int i = 0; i<m; i++){
                ans = Math.max(ans,newRow[i] * (m-i));
            }
        }
        
        return ans;
    }
}