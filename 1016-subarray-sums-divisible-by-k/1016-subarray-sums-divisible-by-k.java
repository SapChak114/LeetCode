class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, prefixSum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i<n; i++) {
            prefixSum += nums[i];
            int rem = ((prefixSum % k) + k ) % k;
            res += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return res;
    }
}