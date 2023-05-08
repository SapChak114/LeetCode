class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        
        for(int i = 0; i<mat.length; i++){
            if(i == mat[i].length-1-i){
                sum += mat[i][i];
            } else{
                sum += mat[i][i] + mat[i][mat[i].length-1-i];
            }
        }
        
        return sum;
    }
}