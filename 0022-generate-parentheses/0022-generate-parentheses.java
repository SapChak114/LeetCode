class Solution {
    List<String> list;
    int n;
    public List<String> generateParenthesis(int n) {
        this.list = new ArrayList<>();
        this.n = n;
        rec(0, 0, "");

        return this.list;
    }

    void rec(int left, int right, String br) {
        if (br.length() == 2 * n) {
            list.add(br);
            return;
        }

        if (left < n) {
            rec(left + 1, right, br + "(");
        } 


        if (right < left) {
            rec(left, right+1, br + ")");
        }
    }
}