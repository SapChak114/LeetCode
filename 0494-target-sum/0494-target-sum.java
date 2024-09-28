class Solution {
    int n, target;
    Map<String, Integer> dp;
    int[] nums;
    public int findTargetSumWays(int[] nums, int target) {
        this.n = nums.length;
        this.target = target;
        this.nums = nums;
        this.dp = new HashMap<>();
        return rec(0, 0);
    }

    int rec(int idx, int total) {
        if (idx == n) {
            if (total == target) {
                return 1;
            }
            return 0;
        }

        String key = idx+"-"+total;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int val = rec(idx + 1, total + nums[idx]) + rec(idx + 1, total - nums[idx]);

        dp.put(key, val);
        return val;
    }
}