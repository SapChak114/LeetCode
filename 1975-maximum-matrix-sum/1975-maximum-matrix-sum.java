class Solution {
    public long maxMatrixSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int negCount = 0, smallestAbs = Integer.MAX_VALUE;
        long sum = 0l;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                int val = mat[i][j];
                if (val < 0) {
                    negCount++;
                }
                smallestAbs = Math.min(smallestAbs, Math.abs(val));
                sum += Math.abs(val);
            }
        }

        //System.out.println(sum + " " + negCount + " " + smallestAbs);

        if ((negCount&1) != 0) {
            return sum - (2 * Math.abs(smallestAbs));
        }

        return sum;
    }
}