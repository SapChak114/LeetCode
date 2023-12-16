class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int major = 0, count = 0;
        
        for(int num : nums){
            if(count == 0){
                count++;
                major = num;
            }
            else if(num == major) count++;
            else count--;
        }
        
        return major;
    }
}