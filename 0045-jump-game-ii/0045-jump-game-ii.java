class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, n = nums.length, count = 0;

        while (r < n-1) {
            int farthest = 0;
            for (int i = l; i<=r; i++) {
                farthest = Math.max(farthest, nums[i]+i);
            }
            l = r;
            r = farthest;
            count++;
        }

        return count;
    }
}