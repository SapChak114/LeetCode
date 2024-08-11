class Solution {
    public int regionsBySlashes(String[] grid) {
        int T = 3, n = grid.length;

        int[][] mat = new int[T*n][T*n];

        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[i].length(); j++) {
                int r = T*i;
                int c = T*j;
                if (grid[i].charAt(j) == '\\') {
                    mat[r][c] = 1;
                    mat[r+1][c+1] = 1;
                    mat[r+2][c+2] = 1;    
                } else if (grid[i].charAt(j) == '/') {
                    mat[r][c+2] = 1;
                    mat[r+1][c+1] = 1;
                    mat[r+2][c] = 1;
                }
            }
        }

        // for (int[] m : mat) {
        //     System.out.println(Arrays.toString(m));
        // }

        boolean[][] seen = new boolean[mat.length][mat[0].length];
        int count = 0;
        for (int i = 0; i<mat.length; i++) {
            for (int j = 0; j<mat[i].length; j++) {
                if (!seen[i][j] && mat[i][j] == 0) {
                    dfs(mat, seen, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int[][] mat, boolean[][] seen, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || seen[i][j] || mat[i][j] == 1) {
            return;
        }
        seen[i][j] = true;

        dfs(mat, seen, i + 1, j);  // down
        dfs(mat, seen, i - 1, j);  // up
        dfs(mat, seen, i, j + 1);  // right
        dfs(mat, seen, i, j - 1);  // left
    }
}