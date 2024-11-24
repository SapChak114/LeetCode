class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int min = Integer.MAX_VALUE;
        int countNeg = 0;
        long sum = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                sum += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));

                if (matrix[i][j] < 0) {
                    countNeg++;
                }
            }
        }

        if (countNeg % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * (min);
        }
    }
}