class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length+1][nums.length+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        return dfs(nums,0,-1);
    }
    int dfs(int[] nums,int idx, int mtn){
        
        if(idx==nums.length){
            return 0;
        }
        //[10,9,2,5,3,7,101,18]
        if(dp[idx][mtn+1]!=-1) return dp[idx][mtn+1];
        
        int take=0,dont=0;
        if(mtn==-1 || (nums[idx]>nums[mtn])){
            take = dfs(nums,idx+1,idx)+1;
        }
        dont = dfs(nums,idx+1,mtn);
        
        int result = Math.max(take,dont);
        
        dp[idx][mtn+1]=result;
        
        return result;
    }
}