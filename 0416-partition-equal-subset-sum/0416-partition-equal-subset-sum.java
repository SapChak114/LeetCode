class Solution {
    int[] nums;
    int n, targSum;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        this.targSum = sum / 2;
        this.dp = new Boolean[n][targSum+1];
        return dfs(0, 0);
    }

    boolean dfs(int index, int sum) {
        if (index >= n || sum > targSum) {
            return false;
        }

        if (sum == targSum) {
            return true;
        }

        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        int newSum = sum + nums[index];

        boolean ans = false;
        if (dfs(index+1, newSum)) {
            ans = true;
        }

        ans |= dfs(index+1, sum);

        return dp[index][sum] = ans;
    }
}