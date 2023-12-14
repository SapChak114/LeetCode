class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int[] rowOnes = new int[n];
        int[] colOnes = new int[m];
        
        int[] rowZeros = new int[n];
        int[] colZeros = new int[m];
        
 
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1) rowOnes[i]++;
                else rowZeros[i]++;
            }
        }
        
        for(int j = 0; j<m; j++){
            for(int i = 0; i<n; i++){
                if(grid[i][j]==1) colOnes[j]++;
                else colZeros[j]++;
            }
        }
        
        for(int row = 0; row<n; row++){
            for(int col = 0; col<m; col++){
                grid[row][col] = rowOnes[row] + colOnes[col] - rowZeros[row] - colZeros[col];
            }
        }
        
        return grid;
    }
}