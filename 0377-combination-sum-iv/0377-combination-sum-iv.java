class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int total = 1; total <= target; total++) {
            dp.put(total, 0);
            for (int n : nums) {
                dp.put(total, dp.getOrDefault(total, 0) + dp.getOrDefault(total - n, 0));
            }
        }

        return dp.get(target);
    }
}