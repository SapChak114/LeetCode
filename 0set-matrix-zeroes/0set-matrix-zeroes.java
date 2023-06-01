class Solution {
    public void setZeroes(int[][] matrix) {
        
        List<List<Integer>> data = new ArrayList<>();
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    int row= -1, col= -1;
                    row = i;
                    col = j;
                    List<Integer> li = new ArrayList<>();
                    li.add(row);
                    li.add(col);
                    data.add(li);
                }
            }
        }
        
        for(int k = 0; k<data.size(); k++){
            int row = data.get(k).get(0);
            int col = data.get(k).get(1);
            for(int i = 0; i<matrix.length; i++){
                matrix[i][col]=0;
            }
            for(int j = 0; j<matrix[0].length; j++){
                matrix[row][j]=0;
            }
        }
        
    }
}