class Solution {
    int[] nums;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int half = sum / 2;

        this.dp = new Boolean[half + 1][nums.length];

        return dfs(half, 0);
    }

    boolean dfs(int val, int idx) {
        if (val == 0) {
            return true;
        }

        if (val < 0 || idx >= nums.length) {
            return false;
        }

        if (dp[val][idx] != null) {
            return dp[val][idx];
        }

        boolean take = dfs(val - nums[idx], idx+1);
        boolean dont = false;
        
        if (!take) {
            dont = dfs(val, idx+1);
        }

        return dp[val][idx] = take || dont;
    }
}