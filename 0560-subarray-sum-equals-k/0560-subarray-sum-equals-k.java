class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0, count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i<n; i++) {
            sum += nums[i];

            int key = sum - k;

            count += map.getOrDefault(key, 0);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}