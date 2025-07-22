class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int start = 0, sum = 0, maxSum = 0;

        for (int end = 0; end<nums.length; end++) {
            while (set.contains(nums[end])) {
                sum -= nums[start];
                set.remove(nums[start++]);
            }

            sum += nums[end];
            maxSum = Math.max(maxSum, sum);
            set.add(nums[end]);
        }

        return maxSum;
    }
}