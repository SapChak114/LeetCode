class Solution {
    int[] X = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int dead = 2, alive = 3;

        int[][] board2 = new int[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                
                int liveNei = 0;
                for (int k = 0; k<X.length; k++) {
                    int r = i + X[k];
                    int c = j + Y[k];
                    if (r < 0 || r >= n || c < 0 || c >= m) {
                        continue;
                    }

                    if (board[r][c] == 1) {
                        liveNei++;
                    }
                }

                if (board[i][j] == 1 && liveNei < 2) {
                    board2[i][j] = dead;
                } else if (board[i][j] == 1 && (liveNei == 2 || liveNei == 3)) {
                    board2[i][j] = alive;
                } else if (board[i][j] == 1 && liveNei > 3) {
                    board2[i][j] = dead;
                } else if (board[i][j] == 0 && liveNei == 3) {
                    board2[i][j] = alive;
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (board2[i][j] == alive) {
                    board[i][j] = 1;
                } else if (board2[i][j] == dead) {
                    board[i][j] = 0;
                }
            }
        }

    }
}