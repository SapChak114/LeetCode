class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, max = 0, bit = 0;

        for (int i = 0; i<n; i++) {
            int curr = 1;
            int used = nums[i];
            for (int j = i+1; j<n; j++) {
                if ((used & nums[j]) == 0) {
                    used |= nums[j];
                    curr++;
                } else {
                    break;
                }
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}