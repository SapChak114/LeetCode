class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] mat = new int[m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (matrix[i][j] == '1') {
                    mat[j]++;
                } else {
                    mat[j] = 0;
                }
            }

            max = Math.max(max, lra(mat));
        }

        return max;
    }


    int lra(int[] A) {
        int[] idxL = indexOfNearestSmallerElementToTheLeft(A);
        int[] idxR = indexOfNearestSmallerElementToTheRight(A);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<A.length; i++) {
            int val = idxR[i] - idxL[i] - 1;
            max = Math.max(max, A[i] * val);
        }

        return max;
    }

    int[] indexOfNearestSmallerElementToTheLeft(int[] A) {
        int[] ans = new int[A.length];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i<A.length; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    int[] indexOfNearestSmallerElementToTheRight(int[] A) {
        int[] ans = new int[A.length];

        Stack<Integer> st = new Stack<>();
        for (int i = A.length-1; i>=0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? A.length : st.peek();
            st.push(i);
        }

        return ans;
    }
}