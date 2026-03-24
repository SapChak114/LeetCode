class Solution {
    int MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long prod = 1;
        int[][] res = new int[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                res[i][j] = (int) prod;
                prod = (prod * (grid[i][j] % MOD)) % MOD;
            }
        }

        prod = 1;
        for (int i = n-1; i>=0; i--) {
            for (int j = m-1; j>=0; j--) {
                res[i][j] = (int) (((long)prod * res[i][j]) % MOD);
                prod = (prod * (grid[i][j] % MOD)) % MOD;
            }
        }

        return res;
    }
}