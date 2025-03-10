class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    String word;
    int n, m;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.word = word;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (dfs(i, j, vis, 0, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int i, int j, boolean[][] vis, int pos, char[][] board) {
        if (pos == word.length()) {
            return true;
        }       

        if (i < 0 || i>= n || j < 0 || j >= m || vis[i][j] || word.charAt(pos) != board[i][j]) {
            return false;
        }

        vis[i][j] = true;
        for (int k = 0; k<4; k++) {
            int x = X[k] + i;
            int y = Y[k] + j;

            if (dfs(x, y, vis, pos + 1, board)) {
                return true;
            }
        }
        vis[i][j] = false;

        return false;
    }
}