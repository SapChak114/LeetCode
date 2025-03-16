class Solution {
    String s;
    Integer[][] dp;
    int n;
    public String longestPalindrome(String s) {
        this.s = s;
        this.n = s.length();
        this.dp = new Integer[n+1][n+1];

        dfs(0, n-1);
        int max= Integer.MIN_VALUE, start = 0;

        for (int i = 0; i<n; i++) {
            for (int j = n-1; j>=0; j--) {
                if (dp[i][j] != null && dp[i][j] == 1 && j-i+1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start+max);
    }

    int dfs(int i, int j) {
        if (i == j) {
            return dp[i][j] = 1; 
        }

        if (i > j) {
            return 1;
        }

        if (dp[i][j] != null) {
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