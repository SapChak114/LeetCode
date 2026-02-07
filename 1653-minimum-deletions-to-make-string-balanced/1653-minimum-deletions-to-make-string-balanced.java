class Solution {
    public int minimumDeletions(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        int elem = 0;
        for (char c : ch) {
            if (!st.isEmpty() && st.peek() == 'b' && c == 'a') {
                st.pop();
                elem++;
            } else {
                st.push(c);
            }
        }

        return elem;
    }
}