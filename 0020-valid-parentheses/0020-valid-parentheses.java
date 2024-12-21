class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i<n; i++) {
            char c = ch[i];

            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (!st.isEmpty() && 
                (
                (st.peek() == '(' && s.charAt(i) == ')')
                || (st.peek() == '{' && s.charAt(i) == '}')
                || (st.peek() == '[' && s.charAt(i) == ']')
                )) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}