class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();

        Stack<Character> st = new Stack<>();
        for (char c : ch) {
             if (c == '(' || c == '[' || c=='{') {
                st.push(c);
             } else if (st.isEmpty()) {
                return false;
             } else {
                char br = st.pop();
                switch(c) {
                    case ']':
                        if (br == '(' || br == '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (br == '[' || br == '{') {
                            return false;
                        }
                        break;
                    case '}':
                        if (br == '(' || br == '[') {
                            return false;
                        }
                        break;
                }
             }
        }

        return st.isEmpty();
    }
}