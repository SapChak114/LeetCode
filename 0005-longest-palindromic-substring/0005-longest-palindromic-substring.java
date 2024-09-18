class Solution {
    int[][] dp;
    String s;
    public String longestPalindrome(String s) {
        int n = s.length();
        this.s = s;
        this.dp = new int[n+1][n+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        dfs (0, n-1);
        int max = 0, start = 0;

        for (int i = 0; i<n; i++) {
            for (int j = n-1; j>=i; j--) {
                if (dp[i][j] == 1 && j-i+1 > max) {
                    max = j-i+1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }

    int dfs (int i, int j) {
        if (i == j) {
            return dp[i][j] = 1;
        }

        if (i > j) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j) && dfs(i+1, j-1) == 1) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = 0;
        }

        dfs(i+1, j);
        dfs(i, j-1);

        return dp[i][j];
    }
}