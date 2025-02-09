class Solution {
    public long countBadPairs(int[] nums) {
         long goodPairs = 0, totalPairs = 0;
         Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            totalPairs += i;
            goodPairs += freq.getOrDefault(i - nums[i], 0);
            freq.put(i - nums[i], freq.getOrDefault(i - nums[i], 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}