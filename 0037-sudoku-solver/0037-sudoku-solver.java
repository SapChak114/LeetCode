class Solution {
    public void solveSudoku(char[][] board) {
        sudoku(board, 0);
    }

    boolean sudoku(char[][] board, int pos) {
        if (pos == 81) {
            return true;
        }

        int row = pos/9;
        int col = pos%9;

        if (board[row][col] != '.') {
            return sudoku(board, pos+1);
        } else {

            for (char c = '1'; c<='9'; c++) {
                if (valid(board, c, pos)) {
                    board[row][col] = c;
                    if (sudoku(board, pos+1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    boolean valid(char[][] board, char c, int pos) {
        int row = pos/9;
        int col = pos%9;

        int rowCell = (row/3)*3;
        int colCell = (col/3)*3;

        for (int i = rowCell; i<rowCell+3; i++) {
            for (int j = colCell; j<colCell+3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        for (int i = 0; i<9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        for (int j = 0; j<9; j++) {
            if (board[row][j] == c) {
                return false;
            }
        }

        return true;
    }
}