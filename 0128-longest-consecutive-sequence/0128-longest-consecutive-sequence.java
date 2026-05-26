class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            int len = 0;
            if (!set.contains(num - 1)) {
                while (set.contains(num + len)) {
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}