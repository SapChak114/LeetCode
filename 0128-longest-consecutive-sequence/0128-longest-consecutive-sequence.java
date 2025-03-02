class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length, count = 0, max = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i<n-1; i++) {
            if (nums[i] + 1 == nums[i+1]) {
                count++;
            } else if (nums[i+1] == nums[i]) {
                continue;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        return Math.max(max, count) + 1;
    }
}