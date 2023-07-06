class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            sum += nums[right];
            if(sum>=target){
                while(sum>=target){
                    sum -= nums[left++];
                }
                res = Math.min(res,right-left+2);
            }
            right++;
        }
        
        return res==Integer.MAX_VALUE?0:res;
    }
}