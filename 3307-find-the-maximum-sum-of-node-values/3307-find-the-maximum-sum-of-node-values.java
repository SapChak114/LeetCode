class Solution {
    Map<String, Long> dp;
    int[] nums;
    int k;
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        this.dp = new HashMap<>();
        this.nums = nums;
        this.k = k;
        return rec(0, true);
    }

    long rec(int idx, boolean isEven) {
        if (idx == nums.length) {
            return isEven ? 0 : Integer.MIN_VALUE;
        }

        String key = idx+"-"+isEven;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        long dont = nums[idx] + rec(idx + 1, isEven);
        long take = (nums[idx]^k) + rec(idx + 1, !isEven);

        long val = Math.max(dont, take);

        dp.put(key, val);

        return val;
    }
}