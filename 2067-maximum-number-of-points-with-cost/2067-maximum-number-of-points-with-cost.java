class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long[] row = Arrays.stream(points[0]).asLongStream().toArray();

        for (int r = 1; r<n; r++) {
            long[] nextR = new long[m];
            long[] l = new long[m];
            long[] rt = new long[m];
            l[0] = row[0];

            for (int c = 1; c<m; c++) {
                l[c] = Math.max(row[c], l[c-1]-1);
            }

            rt[m-1] = row[m-1];
            for (int c = m-2; c>=0; c--) {
                rt[c] = Math.max(row[c], rt[c+1]-1);
            }

            for (int c = 0; c<m; c++) {
                nextR[c] = points[r][c] + Math.max(l[c], rt[c]);
            }

            row = nextR;
        }

        return Arrays.stream(row).max().getAsLong();
    }
}