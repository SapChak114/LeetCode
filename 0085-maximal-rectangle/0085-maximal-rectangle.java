class Solution {
    public int maximalRectangle(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] ma = new int[m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (mat[i][j] == '1') {
                    ma[j]++;
                } else {
                    ma[j] = 0;
                }
            }
            max = Math.max(max, lra(ma));
        }

        return max;
    }

    int lra(int[] A) {
        int[] leftSmall = leftSmall(A);
        int[] rightSmall = rightSmall(A);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<A.length; i++) {
            int val = rightSmall[i] - leftSmall[i] - 1;
            max = Math.max(max, A[i] * val);
        }

        return max;
    }

    int[] leftSmall(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i<n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    int[] rightSmall(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i>=0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }
}