class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, sum = 0, res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int right = 0; right<n; right++) {
            sum += nums[right];

            int key = ((sum % k) + k) % k;

            res += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return res;
    }
}