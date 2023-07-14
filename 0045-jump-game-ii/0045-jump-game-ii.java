class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        
        Arrays.fill(dp,(int)1e5);
        
        dp[0] = 0;
        for(int i = 0; i<n-1; i++){
            if(i+nums[i]>=n-1){
                dp[n-1] = Math.min(dp[n-1],dp[i]+1);
                break;
            }
            
            for(int j = i+1; j<=nums[i]+i; j++){
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
        }
        
        return dp[n-1];
    }
    
}