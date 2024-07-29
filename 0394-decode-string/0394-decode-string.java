class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                st.push(""+c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!st.empty() && !st.peek().equals("[")) {
                    sb.insert(0,st.pop());
                }
                st.pop();

                StringBuilder numStr = new StringBuilder();
                while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                    numStr.insert(0, st.pop());
                }

                int num = Integer.parseInt(numStr.toString());
                st.push(sb.toString().repeat(num));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.empty()) {
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}