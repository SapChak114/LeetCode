class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    al.add(a);
                }
            }
        }

        for(int i = 0; i<al.size(); i++){
            Arrays.fill(matrix[al.get(i).get(0)],0);
            for(int j = 0; j<matrix.length; j++){
                matrix[j][al.get(i).get(1)]=0;
            }
        }

    }
}