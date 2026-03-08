class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, sum = 0, maxSum = nums[0];

        for (int i = 0; i<n; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}