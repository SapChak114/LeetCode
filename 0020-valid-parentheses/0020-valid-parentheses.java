class Solution {
    public boolean isValid(String s) {
        char[] cha = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (char c : cha) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (st.isEmpty()) {
                return false;
            } else {
                char ch = st.pop();
                switch(c) {
                    case '}':
                        if (ch == '[' || ch == '(') {
                            return false;
                        }
                        break;
                    
                    case ']':
                        if (ch == '(' || ch == '{') {
                            return false;
                        }
                        break;
                    
                    case ')':
                        if (ch == '[' || ch == '{') {
                            return false;
                        }
                        break;
                }   
            }
        }

        return st.isEmpty();
    }
}