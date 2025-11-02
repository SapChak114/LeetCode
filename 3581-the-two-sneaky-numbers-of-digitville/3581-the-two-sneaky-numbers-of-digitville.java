class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (set.contains(num)) {
                res.add(num);
            }
            set.add(num);
        }

        int[] dups = new int[res.size()];
        for (int i = 0; i<res.size(); i++) {
            dups[i] = res.get(i);
        }

        return dups;
    }
}