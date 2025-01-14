class Solution {
    Boolean[][] memo;
    int n;
    String s;
    public boolean checkValidString(String s) {
        this.n = s.length();
        this.memo = new Boolean[n][n];
        this.s = s;

        return dfs(0, 0);
    }

    boolean dfs(int i, int p) {
        if (i == n) {
            return p == 0;
        }

        if (memo[i][p] != null) {
            return memo[i][p];
        }

        boolean isValid = false;
        if (s.charAt(i) == '*') {
            isValid |= dfs(i+1, p+1);
            if (p > 0) {
                isValid |= dfs(i+1, p-1);
            }
            isValid |= dfs(i+1, p);
        } else {
            if (s.charAt(i) == '(') {
                isValid = dfs(i+1, p+1);
            } else if (p > 0) {
                isValid = dfs(i+1, p-1);
            }
        }

        return memo[i][p] = isValid;
    }
}