class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;

        int maxLen = 2;
        int left = 0;
        int maxProd = 1;

        for (int right = 0; right<n; right++) {
            while (gcd(maxProd, nums[right]) > 1) {
                maxProd /= nums[left++];
            }

            maxProd *= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}