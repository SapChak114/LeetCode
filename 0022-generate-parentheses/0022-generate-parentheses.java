class Solution {
    int n;
    Stack<String> st;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        this.st = new Stack<>();
        this.res = new ArrayList<>();
        this.n = n;
        back(0, 0);
        return this.res;
    }

    void back(int open, int close) {
        if (open == n && close == n) {
            res.add(String.join("", st));
        }

        if (open < n) {
            st.push("(");
            back(open + 1, close);
            st.pop();
        }

        if (close < open) {
            st.push(")");
            back(open, close + 1);
            st.pop();
        }
    }
}