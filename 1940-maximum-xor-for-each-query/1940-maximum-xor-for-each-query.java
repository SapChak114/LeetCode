class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length;

        for (int num : nums) {
            xor ^= num;
        }

        int[] answer = new int[n];
        int mask = (1 << maximumBit) - 1;
        
        for (int i = 0; i < n; i++) {
            answer[i] = xor ^ mask;
            xor ^= nums[n - i - 1];
        }

        return answer;
    }
}