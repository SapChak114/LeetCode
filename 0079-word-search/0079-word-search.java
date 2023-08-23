class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int i, int j, int pos, char[][] board, String word) {
        if (pos == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }

        char original = board[i][j];
        board[i][j] = '#';  // Mark the cell as visited
        
        for (int k = 0; k < 4; k++) {
            if (dfs(i + dirX[k], j + dirY[k], pos + 1, board, word)) {
                return true;
            }
        }

        board[i][j] = original;  // Restore the cell

        return false;
    }
}
