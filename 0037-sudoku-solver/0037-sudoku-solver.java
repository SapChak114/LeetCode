class Solution {
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        solve(0);
    }
    
    boolean solve(int pos){
        if(pos==81){
            return true;
        }
        
        int row = pos/9;
        int col = pos%9;
        
        if(board[row][col]!='.'){
            return solve(pos+1);
        } else{
            for(char c = '1'; c<='9'; c++){
                if(check(c,pos)){
                    board[row][col]=c;
                    if(solve(pos+1)) return true;
                    board[row][col]='.';
                }
            }
        }
        
        return false;
    }
    
    boolean check(char c, int pos){
        int row = pos/9;
        int col = pos%9;
        
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        
        for(int i = rowStart; i<rowStart+3; i++){
            for(int j = colStart; j<colStart+3; j++){
                if(board[i][j]==c) return false;
            }
        }
        
        for(int i = 0; i<9; i++){
            if(board[i][col]==c) return false;
        }
        
        for(int j = 0; j<9; j++){
            if(board[row][j]==c) return false;
        }
        
        return true;
    }
}