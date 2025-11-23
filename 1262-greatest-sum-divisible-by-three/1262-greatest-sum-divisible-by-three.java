class Solution {
    public int maxSumDivThree(int[] nums) {
        int small_one = (int)1e4+9;
        int small_two = (int)1e4+9;
        int total = 0;

        for (int i = 0; i<nums.length; i++) {
            total += nums[i];
            if (nums[i] % 3 == 1) {
                small_two = Math.min(small_two, nums[i] + small_one);
                small_one = Math.min(small_one, nums[i]);
            }

            if (nums[i] % 3 == 2) {
                small_one = Math.min(small_one, nums[i] + small_two);
                small_two = Math.min(small_two, nums[i]);
            }
        }

        if (total % 3 == 0) {
            return total;
        } else if (total % 3 == 1) {
            return total - small_one;
        } else if (total % 3 == 2){
            return total - small_two;
        }

        return -1;
    }
}