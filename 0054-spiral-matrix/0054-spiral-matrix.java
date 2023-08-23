class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length-1, top = 0, down = matrix.length-1;
        
        List<Integer> list = new ArrayList<>();
        while(left<=right && top<=down){
            
            for(int i = left; i<=right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            
            for(int i = top; i<=down; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(!(left<=right && top<=down)){
                break;
            }
            for(int i = right; i>=left; i--){
                list.add(matrix[down][i]);
            }
            down--;
            
            for(int i = down; i>=top; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        
        return list;
    }
}