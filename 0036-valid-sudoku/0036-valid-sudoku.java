class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        int n = board.length, m = board[0].length;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }

                String row = ch + "-row-" + i;
                String col = ch + "-col-" + j;
                String box = ch + "-box-" +(i/3) + "-" + (j/3);

                if (!set.add(row) || !set.add(col) || !set.add(box)) {
                    return false;
                }
            }
        }

        return true;
    }
}