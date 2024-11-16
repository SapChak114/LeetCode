class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int s = 0; s <= n-k; s++) {
            boolean isConsecutiveAndSorted = true;

            for (int idx = s; idx < s + k - 1; idx++) {
                if (nums[idx + 1] != nums[idx] + 1) {
                    isConsecutiveAndSorted = false;
                    break;
                }
            }

            if (isConsecutiveAndSorted) {
                res[s] = nums[s + k -1];
            } else {
                res[s] = -1;
            }
        }

        return res;
    }
}