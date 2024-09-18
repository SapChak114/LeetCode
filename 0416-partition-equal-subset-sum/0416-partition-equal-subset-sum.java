class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return dfs(nums, target, dp, n-1);
    }

    boolean dfs(int[] nums, int targ, int[][] dp, int idx) {
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
            take = dfs(nums, targ - nums[idx], dp, idx - 1);
        }
        boolean dont = dfs(nums, targ, dp, idx - 1);

        dp[idx][targ] = (take || dont) ? 1 : 0;

        return dp[idx][targ] == 1;
    }
}