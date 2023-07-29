class Solution {
    char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return sudoku(0);
    }
    
    boolean sudoku(int pos){
        if(pos==81){
            return true;
        }
        int row = pos/9;
        int col = pos%9;
        
        if(board[row][col]!='.' && check(row,col,board[row][col],pos)){
            return sudoku(pos+1);
        }
        else if(board[row][col]=='.'){
            return sudoku(pos+1);
        }
        
        return false;
    }
    
    boolean check(int row, int col, char elem, int pos){
        
        int r = pos/9;
        int c = pos%9;
        
        int rowCell = (r/3)*3;
        int colCell = (c/3)*3;
        
        int count = 0;
        for(int i = 0; i<9; i++){
            if(board[i][col]==elem){
                count++;
            }
            if(count>1) return false;
        }
        count = 0;
        for(int i = 0; i<9; i++){
            System.out.println(board[row][i]);
            if(board[row][i]==elem){
                count++;
            }
            if(count>1) return false;
        }
        
        count = 0;
        for(int i = rowCell; i<rowCell+3; i++){
            for(int j = colCell; j<colCell+3; j++){
                if(board[i][j]==elem){
                    count++;
                }
                if(count>1) return false;
            }
        }
        
        return true;
    }
}