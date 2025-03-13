class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        return canPlace(board, word) || canPlace(board, new StringBuilder(word).reverse().toString());
    }

    boolean canPlace(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        // Check horizontal placement
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<=(n - word.length()); j++) {
                if (canPlaceHorizontally(board, i, j, word)) {
                    return true;
                }
            }
        }

        // Check vertical placement
        for (int j = 0; j<n; j++) {
            for (int i = 0; i<=(m - word.length()); i++) {
                if (canPlaceVertically(board, i, j, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean canPlaceHorizontally(char[][] board, int row, int col, String word) {
        int n = board[0].length;
        int len = word.length();

        if (col > 0 && board[row][col - 1] != '#') {
            return false;
        }
        if (col + len < n && board[row][col+len] != '#') {
            return false;
        }

        for (int k = 0; k<len; k++) {
            if (board[row][col + k] != ' ' && board[row][col + k] != word.charAt(k)) {
                return false;
            }
        }

        return true;
    }

    boolean canPlaceVertically(char[][] board, int row, int col, String word) {
        int m = board.length;
        int len = word.length();
        
        // Check if the word can fit without any boundary violations
        if (row > 0 && board[row - 1][col] != '#') return false;
        if (row + len < m && board[row + len][col] != '#') return false;
        
        for (int k = 0; k < len; k++) {
            if (board[row + k][col] != ' ' && board[row + k][col] != word.charAt(k)) return false;
        }
        return true;
    }
}