class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i<n; i+=3) {
            if (check(i, nums)) {
                return ans;
            }
            ans++;
        }

        return ans;
    }


    boolean check(int start, int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = start; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
}