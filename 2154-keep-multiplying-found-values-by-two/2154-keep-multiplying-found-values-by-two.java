class Solution {
    public int findFinalValue(int[] nums, int org) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(org)) {
            org *= 2;
        }

        return org;
    }
}