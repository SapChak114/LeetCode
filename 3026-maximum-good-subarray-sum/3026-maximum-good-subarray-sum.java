class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Long> pre = new HashMap<>();
        long res = Long.MIN_VALUE;
        long cur = 0;

        for (int num : nums) {
            pre.merge(num, cur, Math::min);
            cur += num;

            if (pre.containsKey(num-k)) {
                res = Math.max(res, cur - pre.get(num-k));
            }
            if (pre.containsKey(num+k)) {
                res = Math.max(res, cur - pre.get(num+k));
            }
        }

        return res == Long.MIN_VALUE ? 0 : res;
    }
}