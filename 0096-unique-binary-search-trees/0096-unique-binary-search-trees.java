class Solution {
    Integer[] dp;
    public int numTrees(int n) {
        this.dp = new Integer[n+1];
        return helper(n);
    }

    int helper(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        int total = 0;
        for (int root = 1; root <=n; root++) {
            int left = helper(root - 1);
            int right = helper(n - root);

            total += left * right;
        }

        return dp[n] = total;
    }
}