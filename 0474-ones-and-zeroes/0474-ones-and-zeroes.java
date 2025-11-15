class Solution {
    // public int findMaxForm(String[] S, int M, int N) {
    //     int[][] dp = new int[M+1][N+1];
    //     for (String str : S) {
    //         int zeros = 0, ones = 0;
    //         for (char c : str.toCharArray())
    //             if (c == '0') zeros++;
    //             else ones++;
    //         for (int i = M; i >= zeros; i--)
    //             for (int j = N; j >= ones; j--)
    //                 dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
    //     }
    //     return dp[M][N];
    // }

    public int findMaxForm(String[] strs, int m, int n) {
        // Using a HashMap for memoization
        Map<String, Integer> dp = new HashMap<>();
        return dfs(strs, 0, m, n, dp);
    }

    private int dfs(String[] strs, int i, int m, int n, Map<String, Integer> dp) {
        if (i == strs.length) {
            return 0;
        }
        String key = i + "," + m + "," + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int mCount = 0, nCount = 0;
        for (char c : strs[i].toCharArray()) {
            if (c == '0') mCount++;
            if (c == '1') nCount++;
        }
        // Option 1: Skip the current string
        int result = dfs(strs, i + 1, m, n, dp);

        // Option 2: Include the current string if possible
        if (mCount <= m && nCount <= n) {
            result = Math.max(result, 1 + dfs(strs, i + 1, m - mCount, n - nCount, dp));
        }
        dp.put(key, result);
        return result;
    }
}