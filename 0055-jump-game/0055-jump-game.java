class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        this.dp = new int[nums.length];
        return recc(0, nums) == 1 ? true : false;
    }

public int recc(int idx, int[] nums){
        if(idx==nums.length-1){
            return 1;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int steps = nums[idx];
        for (int i = idx + 1; i <= idx + steps && i < nums.length; i++) {
            if (recc(i, nums) == 1) {
                dp[idx] = 1;
                return 1;
            }
        }
        dp[idx] = -1;
        return -1;
    }
}