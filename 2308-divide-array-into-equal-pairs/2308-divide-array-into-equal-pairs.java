class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);

        // Check consecutive pairs in sorted array
        for (int pos = 0; pos < nums.length; pos += 2) {
            // If any pair doesn't match, we can't form n equal pairs
            if (nums[pos] != nums[pos + 1]) {
                return false;
            }
        }

        return true;
    }
}