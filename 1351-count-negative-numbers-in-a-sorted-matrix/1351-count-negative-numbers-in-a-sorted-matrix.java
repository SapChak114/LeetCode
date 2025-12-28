class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int r = n - 1, c = 0, count = 0;

        while (r >= 0 && c < m) {
            if (grid[r][c] < 0) {
                r--;
                count += (m - c);
            } else {
                c++;
            }
        }

        return count;
    }
}