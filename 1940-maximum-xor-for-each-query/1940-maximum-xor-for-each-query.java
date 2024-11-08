class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length;

        for (int num : nums) {
            xor ^= num;
        }

        int[] answer = new int[n];
        int mask = (1 << maximumBit) - 1;
        int idx = 0;
        for (int i = nums.length - 1; i>=0; i--) {
            answer[idx++] = xor ^ mask;
            xor ^= nums[i];
        }

        return answer;
    }
}