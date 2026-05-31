class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length, left = 1, right = (int)1e9;

        while (left < right) {
            int mid = (left + right) / 2, count = 0;

            for (int i = 0; i<n; i++) {
                if (nums[i] <= mid) {
                    count++;
                    i++;
                }
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}