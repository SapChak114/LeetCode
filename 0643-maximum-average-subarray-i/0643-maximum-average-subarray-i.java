class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, sum = 0, res = 0;

        for (int i = 0; i<k; i++) {
            sum += nums[i];
        }

        res = sum;

        for (int i = k; i<n; i++) {
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }

        return (double)res/k;
    }
}