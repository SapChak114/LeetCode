class Solution {
    public int minSubArrayLen(int targ, int[] nums) {
        int res = Integer.MAX_VALUE;
        
        int left = 0, right = 0, n = nums.length;
        
        int sum = 0;
        while(right<n){
            sum += nums[right];
            
            while(sum>=targ){
                res = Math.min(res,right-left+1);
                sum -= nums[left++];
            }
            
            right++;
        }
        
        return res==Integer.MAX_VALUE?0:res;
    }
}