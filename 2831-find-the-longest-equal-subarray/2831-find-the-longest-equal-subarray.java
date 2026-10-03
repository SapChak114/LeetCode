class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.size(), max = Integer.MIN_VALUE, l = 0;
        for (int r = 0; r<n; r++) {
            map.put(nums.get(r), map.getOrDefault(nums.get(r), 0) + 1);
            max = Math.max(max, map.get(nums.get(r)));
            
            int rem = r - l + 1 - max;
            if (rem > k) {
                map.put(nums.get(l), map.get(nums.get(l)) - 1);
                if (map.get(nums.get(l)) == 0) {
                    map.remove(nums.get(l));
                }
                l++;
            }
        }

        return max;
    }
}