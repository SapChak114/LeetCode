class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int n = nums.length, prefix = 0;

        for (int i = 0; i<n; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            ans.add(prefix == 0);
        }

        return ans;
    }
}