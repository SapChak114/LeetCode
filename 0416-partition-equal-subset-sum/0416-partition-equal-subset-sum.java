class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int targ = sum / 2;

        int[][] dp = new int[n][targ + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return dfs(nums, dp, targ, n - 1);
    }

    boolean dfs(int[] nums, int[][] dp, int targ, int idx) {
        if (idx < 0 && targ != 0) {
            return false;
        }

        if (idx == 0) {
            return nums[idx] == targ;
        }

        if (dp[idx][targ] != -1) {
            return dp[idx][targ] == 1;
        }

        boolean take = false;
        if (nums[idx] <= targ) {
            take = dfs(nums, dp, targ - nums[idx], idx - 1);
        }

        boolean dont = dfs(nums, dp, targ, idx - 1);

        dp[idx][targ] = (take || dont) ? 1 : 0;

        return dp[idx][targ] == 1;
    }
}