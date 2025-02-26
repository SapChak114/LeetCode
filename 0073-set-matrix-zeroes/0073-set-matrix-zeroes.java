class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] mat2 = new int[n][m];
        for (int[] ma : mat2) {
            Arrays.fill(ma, -1);
        }


        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                mat2[i][j] = mat[i][j];
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (mat[i][j] != 0) {
                    continue;
                }

                // entire row 0
                for (int a = 0; a<m; a++) {
                    mat2[i][a] = 0;
                }

                //entire col 0
                for (int b = 0; b<n; b++) {
                    mat2[b][j] = 0;
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (mat2[i][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}