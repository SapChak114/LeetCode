class Solution {
    Integer[][] dp;
    int n;
    int[] nums;
    public boolean predictTheWinner(int[] nums) {
        this.n = nums.length;
        this.dp = new Integer[n][n];
        this.nums = nums;

        return score(0, n-1) >= 0;
    }

    int score(int l, int r) {
        if (dp[l][r] != null) {
            return dp[l][r];
        }

        if (l == r) {
            return nums[l];
        }

        int lScore = nums[l] - score(l+1, r);
        int rScore = nums[r] - score(l, r-1);

        return dp[l][r] = Math.max(lScore, rScore);
    }

}