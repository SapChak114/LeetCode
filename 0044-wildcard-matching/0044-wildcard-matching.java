class Solution {
    Boolean[][] dp;
    int n, m;
    String s, p;
    public boolean isMatch(String s, String p) {
        s += "#";
        p += "#";

        this.n = s.length();
        this.m = p.length();

        this.s = s;
        this.p = p;

        this.dp = new Boolean[n][m];

        return dfs(0, 0);
    }

    boolean dfs(int i, int j) {
        if (i == n && j == m) {
            return true;
        }
        if (i == n || j == m) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (p.charAt(j) == '?' || (p.charAt(j) == s.charAt(i))) {
            return dp[i][j] = dfs(i+1, j+1);
        }

        if (p.charAt(j) == '*') {
            boolean take = dfs(i+1, j);
            boolean dont = dfs(i, j+1);

            return dp[i][j] = take | dont;
        }

        return false;
    }
}