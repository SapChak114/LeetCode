class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i) + "");
            } else {
                // When ']' is encountered, process the substring
                StringBuilder sb = new StringBuilder();
                while (!st.empty() && !st.peek().equals("[")) {
                    sb.insert(0, st.pop());
                }
                st.pop(); // Pop '['

                // Get the number
                StringBuilder numStr = new StringBuilder();
                while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                    numStr.insert(0, st.pop());
                }
                int num = Integer.parseInt(numStr.toString());
                st.push(sb.toString().repeat(num));
            }
        }

        // Construct the final result from the stack
        StringBuilder result = new StringBuilder();
        while (!st.empty()) {
            result.insert(0, st.pop());
        }
        return result.toString();
    }
}