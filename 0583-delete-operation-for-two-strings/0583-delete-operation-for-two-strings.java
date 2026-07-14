class Solution {
    String word1, word2;
    int n,m;
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.n = word1.length();
        this.m = word2.length();
        this.dp = new Integer[n][m];
        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if (i == n || j == m) {
            return Math.max(n - i, m - j);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = dfs(i+1, j+1);
        }

        return dp[i][j] = 1 + Math.min(dfs(i+1, j), dfs(i, j+1));
    }
}