class Pair{
    char a;
    int b;

    public Pair(char a, int b) {
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().a == c) {
                st.peek().b++;
            } else {
                st.push(new Pair(c, 1));
            }

            if (st.peek().b == k) {
                st.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            Pair p = st.pop();
            String str = p.a + "";
            res.append(str.repeat(p.b));
        }

        return res.reverse().toString();
    }
}