class Solution {
    public int removeCoveredIntervals(int[][] in) {
        Arrays.sort(in, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = in.length;

        int max = in[0][1], ans = 1;

        for (int[] i : in) {
            if (i[1] > max) {
                ans++;
                max = i[1];
            }
        }

        return ans;
    }
}