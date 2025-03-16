class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Long, Long> prefixLeft = new HashMap<>();
        long res = Long.MIN_VALUE;
        long cur = 0;

        for (int x : nums) {
            prefixLeft.putIfAbsent((long)x, cur);
            prefixLeft.put((long)x, Math.min(prefixLeft.get((long)x), cur));
            cur += x;

            if (prefixLeft.containsKey((long)(x - k))) {
                res = Math.max(res, cur - prefixLeft.get((long)(x - k)));
            }
            if (prefixLeft.containsKey((long)(x + k))) {
                res = Math.max(res, cur - prefixLeft.get((long)(x + k)));
            }
        }

        return res == Long.MIN_VALUE ? 0 : res;
    }
}