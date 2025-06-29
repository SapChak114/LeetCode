class Solution {
    int mod = (int)1e9 + 7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int r = n - 1, sum = 0;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i<n; i++) {
            pow[i] = (pow[i-1] * 2) % mod;
        }

        int l = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                sum = (sum + pow[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }

        return sum;
    }
}