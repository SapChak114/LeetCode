class Solution {
    int n, m;
    char[][] board;
    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (board[i][j] == 'O' && ((i == 0 || i == n-1) || (j == 0 || j == m-1))) {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    void dfs(int r, int c) {
        if (r >= n || r < 0 || c >= m || c < 0 || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';

        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }
}