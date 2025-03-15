class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> avMap = new HashMap<>();
        Map<Integer, Integer> vacMap = new HashMap<>();

        for (int num : nums) {
            avMap.put(num, avMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i<n; i++) {
            if (avMap.get(nums[i]) <= 0) {
                
                continue;

            } else if (vacMap.getOrDefault(nums[i], 0) > 0) {

                vacMap.put(nums[i], vacMap.getOrDefault(nums[i], 0) - 1);

                avMap.put(nums[i], avMap.getOrDefault(nums[i], 0) - 1);

                vacMap.put(nums[i] + 1, vacMap.getOrDefault(nums[i] + 1, 0) + 1);

            } else if (avMap.getOrDefault(nums[i], 0) > 0 
            && avMap.getOrDefault(nums[i] + 1, 0) > 0 
            && avMap.getOrDefault(nums[i] + 2, 0) > 0) {

                avMap.put(nums[i], avMap.getOrDefault(nums[i], 0) - 1);
                avMap.put(nums[i] + 1, avMap.getOrDefault(nums[i] + 1, 0) - 1);
                avMap.put(nums[i] + 2, avMap.getOrDefault(nums[i] + 2, 0) - 1);

                vacMap.put(nums[i] + 3, vacMap.getOrDefault(nums[i] + 3, 0) + 1);

            } else {

                return false;

            }
        }

        return true;
    }
}