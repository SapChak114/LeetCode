class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, down = n - 1, left = 0, right = m - 1;

        List<Integer> ans = new ArrayList<>();
        while (top <= down && left <= right) {

            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (!(top <= down && left <= right)) {
                break;
            }

            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            down--;

            for (int i = down; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }

        return ans;
    }
}