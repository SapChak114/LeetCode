class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }

        int[][] resultArr = new int[m][n];

        for (int i = 0; i<original.length; i++) {
            resultArr[i / n][i % n] = original[i];
        }

        return resultArr;

    }
}