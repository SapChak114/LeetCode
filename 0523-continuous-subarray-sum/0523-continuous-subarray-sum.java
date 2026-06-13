class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int sum = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];

            int key = sum % k; //if I subtract the remainder then I will get a subarray

            if (mp.containsKey(key) && i - mp.get(key) > 1) {
                return true;
            }

            if (!mp.containsKey(key)) {
                mp.put(key, i);
            }
        }

        return false;
    }
}