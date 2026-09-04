class Solution {
    public int largestRectangleArea(int[] h) {
        int[] leftArr = leftArr(h);
        int[] rightArr = rightArr(h);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<h.length; i++) {
            int val = rightArr[i] - leftArr[i] - 1;
            max = Math.max(max, val * h[i]);
        }

        return max;
    }

    int[] leftArr(int[] h) {
        int n = h.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i<n; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    int[] rightArr(int[] h) {
        int n = h.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = n-1; i>=0; i--) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }
}