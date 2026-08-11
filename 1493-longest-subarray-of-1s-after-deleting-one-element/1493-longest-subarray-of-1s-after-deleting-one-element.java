class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0, left = 0, size = 0;

        for (int right = 0; right < nums.length; right++) {
            zeroCount += nums[right] == 0 ? 1 : 0;

            while (zeroCount > 1) {
                zeroCount -= nums[left] == 0 ? 1 : 0;
                left++;
            }

            size = Math.max(size, right - left);            
        }

        return size;
    }
}