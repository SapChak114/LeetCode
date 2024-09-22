class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            int diff = prefixSum - k;

            if (prefixSumCount.containsKey(diff)) {
                count += prefixSumCount.get(diff);
            }

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}