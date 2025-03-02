class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {

            if (!set.contains(num-1)) {
                int len = 0;   
                while (set.contains(num + len)) {
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}