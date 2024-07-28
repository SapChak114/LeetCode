class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();
        if ((sum&1) == 1) {
            return false;
        }

        int targ = sum/2;
        boolean[] dp = new boolean[targ+1];
        dp[0] = true;
        for (int num : nums) {
            //boolean[] prev = Arrays.copyOf(dp, dp.length);
            for (int i = targ; i>=num; i--) {
                boolean dont = dp[i];
                boolean take = dp[i-num];
                dp[i] = take | dont;
            }
        }

        return dp[targ];
    }
}