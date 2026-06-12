class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();


        for (char ch : num.toCharArray()) {
            int n = ch - '0';

            while (!st.isEmpty() && k > 0 && st.peek() > n) {
                k--;
                st.pop();
            }
            st.push(n);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty() && k > 0) {
            k--;
            st.pop();
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb = sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        String ans = sb.toString();

        return ans.isEmpty() ? "0" : ans;
    }
}