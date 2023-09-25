class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> check = new HashSet<>();
        int n = board.length, m = board[0].length;
        
        for(int r = 0; r<n; r++){
            for(int c = 0; c<m; c++){
                int b = board[r][c];
                String row = "r"+"-"+r+"-"+b;
                String col = "c"+"-"+c+"-"+b;
                String diag = "r"+(r/3)+"-"+"c"+(c/3)+"-"+b;
                if(board[r][c]=='.'){
                    continue;
                }
                if(check.contains(row) || check.contains(col) || check.contains(diag)){
                    return false;
                }
                check.add(row);
                check.add(col);
                check.add(diag);
            }
        }
        
        return true;
    }
}