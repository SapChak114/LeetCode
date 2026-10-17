class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, val = nums[0];

        for (int num : nums) {
            if (count == 0) {
                val = num;
            }

            if (num == val) {
                count++;
            } else {
                count--;
            }
        }

        return val;
    }
}