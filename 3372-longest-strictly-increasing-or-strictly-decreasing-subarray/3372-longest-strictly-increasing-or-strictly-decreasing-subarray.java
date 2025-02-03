class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int incLength = 1, decLength = 1, maxLength = 1;

        for (int pos = 0; pos < n-1; pos++) {
            if (nums[pos + 1] > nums[pos]) {
                incLength++;
                decLength = 1;
            } else if (nums[pos + 1] < nums[pos]) {
                decLength++;
                incLength = 1;
            } else {
                decLength = 1;
                incLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(decLength, incLength));
        }

        return maxLength;
    }
}