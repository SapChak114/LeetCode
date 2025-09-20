class Solution {
    Integer[][] dp;
    String text1, text2;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        this.dp = new Integer[n+1][m+1];

        return rec(n, m);
    }

    int rec(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        int val = 0;
        if (text1.charAt(n-1) == text2.charAt(m-1)) {
            val = 1 + rec(n-1, m-1);
        } else {
            val = Math.max(rec(n-1, m), rec(n, m-1));
        }

        return dp[n][m] = val;
    }
}