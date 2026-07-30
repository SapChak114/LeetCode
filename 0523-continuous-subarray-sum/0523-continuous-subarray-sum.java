class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i<n; i++) {
            sum += nums[i];

            int key = sum % k;
            
            if (map.containsKey(key) && i - map.get(key) > 1) {
                return true;
            }

            if (!map.containsKey(key)) {
                map.put(key, i);
            }
        }

        return false;
    }
}