class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int temp = 0;
        for(int n : nums){
            temp += n;
            ans = Math.max(ans,temp);
            
            if(temp<0){
                temp = 0;
            }
        }
        
        return ans;
    }
}