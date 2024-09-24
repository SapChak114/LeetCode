class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0, r = (rows * cols) - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            int val = matrix[mid / cols][mid % cols];

            if (val == target) {
                return true;
            } else if (val < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}