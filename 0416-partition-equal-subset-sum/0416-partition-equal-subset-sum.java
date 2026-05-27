class Solution {
    int[] nums;
    int targetSum;
    int n;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        this.targetSum = sum / 2;
        this.dp = new Boolean[n][targetSum + 1];
        return dfs(0, 0);
    }

    boolean dfs(int idx, int sum) {
        if (sum == targetSum) {
            return true;
        }

        if (idx == n || sum > targetSum) {
            return false;
        }

        if (dp[idx][sum] != null) {
            return dp[idx][sum];
        }

        boolean take = dfs(idx + 1, sum + nums[idx]);
        boolean dont = dfs(idx + 1, sum);

        return dp[idx][sum] = take | dont;
    }
}