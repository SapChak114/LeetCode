class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, max = 0, n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                ones++;
                max = Math.max(max,ones);
            } else{
                ones = 0;
            }
        }
        
        return max;
    }
}