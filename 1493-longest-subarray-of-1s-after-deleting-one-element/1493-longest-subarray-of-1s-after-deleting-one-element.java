class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int n = nums.length;
        int zeros = 0;
        int res = 0;
        for(int i = 0; i<n; i++){
            zeros += nums[i]==0?1:0;
            
            while(zeros>1){
                zeros -= nums[start]==0?1:0;
                start++;
            }
            
            res = Math.max(res,i-start);
        }
        
        return res;
    }
}