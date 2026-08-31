class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int n = temp.length;

        int[] ans = new int[n];
        for (int i = 0; i<n; i++) {
            while (!st.isEmpty() && temp[st.peek()] < temp[i]) {
                int idx = st.pop();
                int diff = i - idx;
                ans[idx] = diff;
            }
            st.add(i);
        }

        return ans;
    }
}