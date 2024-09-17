class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        this.dp = new Integer[n+1];
        return climb(n);
    }

    int climb(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != null) {
            return dp[n];
        }

        return dp[n] = climb(n-1) + climb(n-2);
    }
}