class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        for(int right = 0; right<n; right++){
            for(int left = 0; left<right; left++){
                if(nums[left]<nums[right]){
                    dp[right] = Math.max(dp[right],1+dp[left]);
                }
            }
        }
        
        int max = 0;
        for(int d : dp) max = Math.max(max,d);
        
        return max;
    }
}