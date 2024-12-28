class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int start = 0; // Start index of the current range
        for (int i = 1; i <= nums.length; i++) {
            // Check if the current number breaks the sequence or we are at the end
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == i - 1) {
                    // Single number range
                    ans.add(String.valueOf(nums[start]));
                } else {
                    // Multi-number range
                    ans.add(nums[start] + "->" + nums[i - 1]);
                }
                // Update start for the next range
                start = i;
            }
        }
        return ans;
    }
}
