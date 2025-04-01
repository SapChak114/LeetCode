class Solution {
    int[][] questions;
    int n;
    Long[] dp;
    public long mostPoints(int[][] questions) {
        this.questions = questions;
        this.n = questions.length;
        this.dp = new Long[n];
        return rec(0);
    }

    long rec(int index) {
        if (index >= n) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int points = questions[index][0];
        int jumps = questions[index][1];

        long take = points + rec(index + jumps + 1);

        long dont = rec(index + 1);

        return dp[index] = Math.max(take, dont);
    }
}