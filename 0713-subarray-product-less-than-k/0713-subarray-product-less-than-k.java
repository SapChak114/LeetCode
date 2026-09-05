class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, prod = 1, n = nums.length, res = 0;

        for (int right = 0; right<n; right++) {
            prod *= nums[right];

            while (prod >= k && left < n) {
                prod /= nums[left++];
            }

            res += right - left + 1;
        }

        return res;
    }
}