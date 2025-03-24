class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                uniqueNums.add(num);
            }
        }
        return uniqueNums.size();
    }
}