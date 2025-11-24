class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length, total = 0;

        for (int num : nums) {
            int rem = num % 3;
            total += Math.min(rem, 3 - rem);
        }

        return total;
    }
}