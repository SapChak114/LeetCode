class Solution {
    public int longestSubarray(int[] nums) {
        int zeros = 0, left = 0, right = 0, n = nums.length, res=Integer.MIN_VALUE;
        
        while(right<n){
            zeros += nums[right]==0?1:0;
            
            while(zeros>1){
                zeros -= nums[left]==1?0:1;
                left++;
            }
            
            res = Math.max(res,right-left);
            
            right++;
        }
        
        return res==Integer.MIN_VALUE?0:res;
    }
}