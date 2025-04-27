class Solution {
    public int countSubarrays(int[] nums) {
        int ans = 0, n = nums.length;

        for (int i = 1; i<n-1; i++) {
            if (nums[i] % 2 == 0 && (nums[i-1] + nums[i+1] == nums[i] / 2)) {
                ans++;
            }
        }

        return ans;
    }
}