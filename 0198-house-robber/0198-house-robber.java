class Solution {
    int[] nums;
    Integer[] dp;
    public int rob(int[] nums) {
        this.nums=nums;
        dp = new Integer[nums.length+1];
        return rec(0);
    }
    
    int rec(int idx){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=null) return dp[idx];
        
        return dp[idx] = Math.max(nums[idx]+rec(idx+2),rec(idx+1));
    }
}