class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        long res = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        long equalPairs = 0;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            equalPairs += count; // Adding `count` new pairs (val, val) with earlier `count` items
            freq.put(val, count + 1);

            while (equalPairs >= k) {
                res += n - right; // All subarrays starting from `left` to `n-1` are valid
                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                equalPairs -= (leftCount - 1); // Removing `left` reduces pairs by (count - 1)
                freq.put(leftVal, leftCount - 1);
                left++;
            }
        }

        return res;
    }
}