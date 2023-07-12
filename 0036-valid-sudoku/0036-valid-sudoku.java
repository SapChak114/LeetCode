class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board, 0);
    }

    boolean solve(char[][] a, int pos) {
        if (pos == 81) {
            return true;
        }

        int row = pos / 9;
        int col = pos % 9;

        if (a[row][col] != '.' && isValid(a,a[row][col],pos)) {
            boolean ans = solve(a,pos+1);
            return ans;
        } else if(a[row][col]=='.') {
            // for (char c = '1'; c <= '9'; c++) {
            //     if (isValid(a, c, pos)) {
            //         a[row][col] = c;
            //         if (solve(a, pos + 1))
            //             return true;
            //         a[row][col] = '.';
            //     }
            // }
            return solve(a,pos+1);
        }
        
        return false;
    }

    boolean isValid(char[][] a, char c, int pos) {
        int row = pos / 9;
        int col = pos % 9;
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (a[i][j] == c && (i!=row || j!=col))
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (a[i][col] == c && i!=row)
                return false;
        }

        for (int j = 0; j < 9; j++) {
            if (a[row][j] == c && j!=col)
                return false;
        }

        return true;
    }
}
