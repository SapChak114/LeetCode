class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        int n = rating.length;

        for (int m = 0; m<n; m++) {
            int leftSmaller = 0, rightLarger = 0;

            for (int i = 0; i<m; i++) {
                if (rating[i] < rating[m]) {
                    leftSmaller++;
                }
            }

            for (int i = m+1; i<n; i++) {
                if (rating[i] > rating[m]) {
                    rightLarger++;
                }
            }
            res += leftSmaller * rightLarger;

            int leftLarger = m - leftSmaller;
            int rightSmaller = n - m - 1 - rightLarger;
            res += leftLarger * rightSmaller;
        }

        return res;
    }
}