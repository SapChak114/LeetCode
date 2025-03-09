class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, count = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<(n+k-1); i++) {
            int color = colors[i%n];
            if (st.isEmpty()) {
                st.push(color);
            } else if ((st.peek() ^ 1) == color) {
                st.push(color);
            } else {
                st = new Stack<>();
                st.push(color);
            }

            if (st.size() >= k) {
                count++;
            }
        }

        return count;
    }
}