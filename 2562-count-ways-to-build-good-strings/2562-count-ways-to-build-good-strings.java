class Solution {
    int zero, one;
    int mod = (int)1e9 + 7;
    Integer[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.zero = zero;
        this.one = one;
        this.dp = new Integer[high + 1];

        int ways = 0;
        for (int end = low; end <= high; end++) {
            ways += dfs(end);
            ways %= mod;
        }

        return ways;
    }

    int dfs(int limit) {
        if (limit < 0) {
            return 0;
        }

        if (limit == 0) {
            return 1;
        }

        if (dp[limit] != null) {
            return dp[limit];
        }

        int count = 0;

        if (limit >= one) {
            count += dfs(limit - one);
            count %= mod;
        }

        if (limit >= zero) {
            count += dfs(limit - zero);
            count %= mod;
        }

        return dp[limit] = count;
    }
}