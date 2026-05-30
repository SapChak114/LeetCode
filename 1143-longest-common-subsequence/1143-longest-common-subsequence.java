class Solution {
    Integer[][] dp;
    String text1;
    String text2;
    int n,m;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.n = text1.length();
        this.m = text2.length();
        this.dp = new Integer[n][m];

        return dfs(n-1, m-1);
    }

    int dfs(int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        int val = 0;
        if (text1.charAt(n) == text2.charAt(m)) {
            val = 1 + dfs(n-1, m-1);
        } else {
            val = Math.max(dfs(n-1, m), dfs(n, m-1));
        }

        return dp[n][m] = val;
    }
}