class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, len = 0;

        for (int i = 0; i<n; i++) {
            Map<Integer, Integer> odd = new HashMap<>();
            Map<Integer, Integer> even = new HashMap<>();

            for (int j = i; j<nums.length; j++) {
                Map<Integer, Integer> map = (nums[j] & 1) == 1 ? odd : even;

                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if (odd.size() == even.size()) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }

        return len;
    }
}