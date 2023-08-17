class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp,1);
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max,dp[i]);
        }
        
        return max;
    }
    
    
    int bs(List<Integer> list, int targ){
        int l = 0, r = list.size();
        
        while(l<r){
            int mid = l + (r-l)/2;
            if(list.get(mid)==targ){
                return mid;
            }
            else if(list.get(mid)<targ){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        
        return l;
    }
}