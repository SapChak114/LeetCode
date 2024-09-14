class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, ans = 1;

        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int count = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == maxVal) {
                count++;
            } else {
                count = 0;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}