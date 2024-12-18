class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<n; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                result[st.pop()] -= prices[i];
            }
            st.push(i);
        }

        return result;
    }
}