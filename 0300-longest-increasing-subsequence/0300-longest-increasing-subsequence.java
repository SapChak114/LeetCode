class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, 1);

        for (int i = n-1; i>=0; i--) {
            for (int j = i + 1; j<n; j++) {
                if (nums[i] < nums[j]) {
                    ans[i] = Math.max(ans[i], 1 + ans[j]);
                }
            }
        }

        return Arrays.stream(ans).max().getAsInt();
    }
}