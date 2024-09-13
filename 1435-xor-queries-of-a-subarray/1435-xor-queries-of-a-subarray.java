class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int n = arr.length;
        int m = q.length;

        int[] res = new int[m];
        for (int i = 0; i<m; i++) {
            int xorSum = 0;
            for (int j = q[i][0]; j<=q[i][1]; j++) {
                xorSum ^= arr[j];
            }
            res[i] = xorSum;
        }

        return res;
    }
}