class Solution {
    int[][] mat;
    int k;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        this.mat = mat;
        this.k = k;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                ans[i][j] = calc(i, j);
            }
        }

        return ans;
    }

    int calc(int a, int b) {
        int sum = 0, n = mat.length, m = mat[0].length;

        for (int i = Math.max(0, (a - k)); i <= Math.min(a + k, n-1); i++) {
            for (int j = Math.max(0, (b - k)); j <= Math.min(b + k, m-1); j++) {
                sum += mat[i][j];
            }
        }

        return sum;
    }
}