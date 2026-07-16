class Solution {
    int n,m;
    String text1, text2;
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        this.n = text1.length();
        this.m = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        this.dp = new Integer[n][m];
        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if (i == n || j == m) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + dfs(i+1, j+1);
        }

        return dp[i][j] = Math.max(dfs(i+1, j), dfs(i, j+1));
    }
}