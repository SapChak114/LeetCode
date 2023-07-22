class Solution {
    int[] nums;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        dp = new int[n+1][n+1];
        for(int[] d: dp) Arrays.fill(d,Integer.MIN_VALUE);
        return rec(0,-1);
    }
    
    int rec(int idx, int prev){
        if(idx==nums.length){
            return 0;
        }
        
        if(dp[idx][prev+1]!=Integer.MIN_VALUE) return dp[idx][prev+1];
        
        int take = 0;
        int dont = rec(idx+1,prev);
        if(prev==-1) take = (1 + rec(idx+1,idx));
        else take = (nums[prev] < nums[idx])? (1 + rec(idx+1,idx)): dont;
        
        dp[idx][prev+1] = Math.max(take,dont);
        return Math.max(take,dont);
    }
}