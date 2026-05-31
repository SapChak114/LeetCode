class Solution {
    int[] nums, colors;
    int n;
    Long[] dp;
    public long rob(int[] nums, int[] colors) {
        this.nums = nums;
        this.colors = colors;
        this.n = nums.length;
        this.dp = new Long[n];
        return dfs(0);
    }

    long dfs(int idx) {
        if (idx == n) {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        long dont = dfs(idx+1);

        int next = (idx + 1 < n && colors[idx] == colors[idx+1]) ? idx + 2 : idx + 1;

        long take = nums[idx] + dfs(next);

        return dp[idx] = Math.max(take, dont);
    }
}