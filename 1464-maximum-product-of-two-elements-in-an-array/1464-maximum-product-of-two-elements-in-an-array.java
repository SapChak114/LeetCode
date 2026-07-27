class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE, sec = Integer.MIN_VALUE -1;

        for (int i = 0; i<n; i++) {
            if (nums[i] > max) {
                sec = max;
                max = nums[i];
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
        }

        return (max - 1) * (sec - 1);
    }
}