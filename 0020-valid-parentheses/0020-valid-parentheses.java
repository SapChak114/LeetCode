class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();

        Stack<Character> st = new Stack<>();
        for (char c : ch) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (st.isEmpty()) {
                return false;
            } else {
                switch (c) {
                    case ')':
                        char cc = st.pop();
                        if (cc == '[' || cc == '{') {
                            return false;
                        }
                        break;
                    case ']':
                        cc = st.pop();
                        if (cc == '(' || cc == '{') {
                            return false;
                        }
                        break;
                    case '}':
                        cc = st.pop();
                        if (cc == '[' || cc == '(') {
                            return false;
                        }
                        break;
                }
            }
        }

        return st.isEmpty();
    }
}