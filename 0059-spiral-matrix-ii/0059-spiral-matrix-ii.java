class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int left = 0, right = n-1, top = 0, down = n-1, count = 1;
        while(left<=right && top<=down){
            for(int i = left; i<=right; i++){
                matrix[top][i]=count++;
            }
            top++;
            for(int i = top; i<=down; i++){
                matrix[i][right]=count++;
            }
            if(!(left<=right && top<=down)) break;
            right--;
            for(int i = right; i>=left; i--){
                matrix[down][i] = count++;
            }
            down--;
            for(int i = down; i>=top; i--){
                matrix[i][left] = count++;
            }
            left++;
        }
        
        return matrix;
    }
}