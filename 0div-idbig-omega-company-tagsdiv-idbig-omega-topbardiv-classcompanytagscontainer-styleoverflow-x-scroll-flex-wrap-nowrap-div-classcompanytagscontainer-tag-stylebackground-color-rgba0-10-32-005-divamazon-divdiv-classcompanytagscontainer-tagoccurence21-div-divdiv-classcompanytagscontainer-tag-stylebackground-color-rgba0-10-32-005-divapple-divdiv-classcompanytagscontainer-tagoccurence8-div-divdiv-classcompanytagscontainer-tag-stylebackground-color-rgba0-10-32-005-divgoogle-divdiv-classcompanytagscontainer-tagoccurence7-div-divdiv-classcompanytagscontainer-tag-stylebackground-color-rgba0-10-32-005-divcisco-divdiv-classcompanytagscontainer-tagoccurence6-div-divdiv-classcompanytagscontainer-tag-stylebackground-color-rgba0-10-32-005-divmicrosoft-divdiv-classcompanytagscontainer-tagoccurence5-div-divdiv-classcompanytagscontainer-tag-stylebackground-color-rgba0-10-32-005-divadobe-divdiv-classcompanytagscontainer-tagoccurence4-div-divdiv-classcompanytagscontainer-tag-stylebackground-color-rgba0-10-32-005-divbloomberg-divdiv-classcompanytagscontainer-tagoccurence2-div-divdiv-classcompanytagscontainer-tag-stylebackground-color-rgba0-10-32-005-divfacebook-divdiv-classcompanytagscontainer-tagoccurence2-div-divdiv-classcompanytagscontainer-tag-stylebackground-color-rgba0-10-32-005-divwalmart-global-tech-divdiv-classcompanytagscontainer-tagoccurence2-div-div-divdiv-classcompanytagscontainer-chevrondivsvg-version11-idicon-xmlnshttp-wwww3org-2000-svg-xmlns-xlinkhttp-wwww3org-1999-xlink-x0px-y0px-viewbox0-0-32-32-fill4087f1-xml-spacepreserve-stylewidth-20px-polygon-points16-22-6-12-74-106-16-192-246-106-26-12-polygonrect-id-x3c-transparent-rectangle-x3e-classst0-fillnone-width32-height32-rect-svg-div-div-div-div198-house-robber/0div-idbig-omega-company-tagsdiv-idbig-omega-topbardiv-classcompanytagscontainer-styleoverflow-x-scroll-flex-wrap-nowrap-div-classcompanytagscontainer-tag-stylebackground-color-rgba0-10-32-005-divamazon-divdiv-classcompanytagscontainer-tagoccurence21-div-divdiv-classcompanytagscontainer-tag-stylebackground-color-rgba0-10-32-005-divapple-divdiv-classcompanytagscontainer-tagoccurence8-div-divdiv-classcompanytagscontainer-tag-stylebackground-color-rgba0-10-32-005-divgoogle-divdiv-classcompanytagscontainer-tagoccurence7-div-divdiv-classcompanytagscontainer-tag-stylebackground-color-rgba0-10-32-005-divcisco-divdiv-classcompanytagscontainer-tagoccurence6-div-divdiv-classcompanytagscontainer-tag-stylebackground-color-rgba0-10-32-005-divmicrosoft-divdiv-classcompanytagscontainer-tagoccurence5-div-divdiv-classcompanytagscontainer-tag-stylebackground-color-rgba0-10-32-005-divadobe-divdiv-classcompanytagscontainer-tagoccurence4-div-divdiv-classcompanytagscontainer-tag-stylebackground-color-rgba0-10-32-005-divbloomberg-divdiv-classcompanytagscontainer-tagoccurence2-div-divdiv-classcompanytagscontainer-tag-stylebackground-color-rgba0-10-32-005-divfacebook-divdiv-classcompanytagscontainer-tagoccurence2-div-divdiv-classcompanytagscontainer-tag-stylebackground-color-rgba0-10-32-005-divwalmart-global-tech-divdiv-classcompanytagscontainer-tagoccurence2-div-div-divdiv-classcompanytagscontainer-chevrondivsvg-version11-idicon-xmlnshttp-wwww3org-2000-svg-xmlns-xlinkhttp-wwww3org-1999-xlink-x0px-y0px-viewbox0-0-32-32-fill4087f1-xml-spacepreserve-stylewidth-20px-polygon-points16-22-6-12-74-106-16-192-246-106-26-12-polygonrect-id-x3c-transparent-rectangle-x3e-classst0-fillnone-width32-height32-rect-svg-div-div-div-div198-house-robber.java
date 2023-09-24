class Solution {
    Integer[] dp;
    int n;
    int[] nums;
    public int rob(int[] nums) {
        this.nums=nums;
        n = nums.length;
        dp = new Integer[n+1];
        return rec(0);
    }
    
    int rec(int idx){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=null) return dp[idx];
        
        int take = nums[idx] + rec(idx+2);
        int dont = rec(idx+1);
        
        return dp[idx] = Math.max(take,dont);
    }
}