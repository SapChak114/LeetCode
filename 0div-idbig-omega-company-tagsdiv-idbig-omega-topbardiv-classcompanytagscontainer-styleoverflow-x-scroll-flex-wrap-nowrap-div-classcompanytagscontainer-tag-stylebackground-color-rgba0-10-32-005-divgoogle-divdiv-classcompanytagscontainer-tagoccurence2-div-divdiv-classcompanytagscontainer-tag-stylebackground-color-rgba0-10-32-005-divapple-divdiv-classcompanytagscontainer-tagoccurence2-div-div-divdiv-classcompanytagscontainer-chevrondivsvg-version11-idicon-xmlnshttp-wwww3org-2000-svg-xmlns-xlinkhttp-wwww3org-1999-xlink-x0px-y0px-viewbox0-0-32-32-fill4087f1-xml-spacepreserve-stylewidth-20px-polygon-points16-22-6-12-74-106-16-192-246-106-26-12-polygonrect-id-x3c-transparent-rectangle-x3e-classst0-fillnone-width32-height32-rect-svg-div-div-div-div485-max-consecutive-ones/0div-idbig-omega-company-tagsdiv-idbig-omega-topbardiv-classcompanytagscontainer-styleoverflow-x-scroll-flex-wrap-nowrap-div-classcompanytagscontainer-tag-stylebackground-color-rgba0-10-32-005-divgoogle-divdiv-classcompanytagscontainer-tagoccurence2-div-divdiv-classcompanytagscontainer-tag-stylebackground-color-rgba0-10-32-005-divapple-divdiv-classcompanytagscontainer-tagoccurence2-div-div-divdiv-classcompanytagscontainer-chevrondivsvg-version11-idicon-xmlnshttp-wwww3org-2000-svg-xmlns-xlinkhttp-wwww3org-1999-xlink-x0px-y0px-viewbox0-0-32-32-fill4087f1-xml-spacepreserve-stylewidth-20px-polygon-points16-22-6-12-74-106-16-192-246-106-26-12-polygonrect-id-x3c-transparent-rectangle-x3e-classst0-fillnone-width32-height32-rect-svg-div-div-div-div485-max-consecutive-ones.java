class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, max = 0, n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                ones++;
            } else{
                max = Math.max(max,ones);
                ones = 0;
            }
        }
        max = Math.max(max,ones);
        return max;
    }
}