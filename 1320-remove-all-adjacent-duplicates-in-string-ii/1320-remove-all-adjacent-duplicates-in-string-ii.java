class Pair{
    char c;
    int a;

    public Pair(char c, int a) {
        this.c = c;
        this.a = a;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().c == c) {
                st.peek().a++;
            } else {
                st.push(new Pair(c, 1));
            }

            if (st.peek().a == k) {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            Pair p = st.pop();
            String str = p.c+"";
            str = str.repeat(p.a);
            sb.append(str);
        }

        return sb.reverse().toString();
    }
}