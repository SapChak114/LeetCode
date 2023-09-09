class Solution {
    int[] nums;
    Integer[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target+1];
        this.nums=nums;
        return rec(target);
    }
    
    int rec(int sum){
        if(sum==0) return 1;
        if(sum<0) return 0;
        
        if(dp[sum]!=null) return dp[sum];
        
        int ans = 0;
        for(int i = 0; i<nums.length; i++) ans += rec(sum - nums[i]);
        
        return dp[sum] = ans;
    }
}