class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        int n = nums.length;

        for (int i = 0; i<n; i++) {
            if (nums[i] == target) {
                if (ans[0] == -1) {
                    ans[0] = i;
                }
                ans[1] = i;
            }
        }

        return ans;
    }
}