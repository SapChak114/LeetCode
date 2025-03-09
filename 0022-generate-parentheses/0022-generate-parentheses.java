class Solution {
    List<String> res;
    Stack<String> st;
    int n;
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.st = new Stack<>();
        this.n = n;
        back(0, 0);
        return res;
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