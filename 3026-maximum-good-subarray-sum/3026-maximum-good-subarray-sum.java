class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long ans = Long.MIN_VALUE;
        long cur = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, cur, Math::min);
            cur += num;

            if (map.containsKey(num+k)) {
                ans = Math.max(ans, cur - map.get(num + k));
            }

            if (map.containsKey(num-k)) {
                ans = Math.max(ans, cur - map.get(num - k));
            }
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}