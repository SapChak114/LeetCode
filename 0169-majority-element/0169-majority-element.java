class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, val = 0, count = 0;

        for(int num : nums){
            if(count == 0){
                val = num;
            }
            if(num == val){
                count++;
            } else{
                count--;
            }
        }

        return val;
    }
}