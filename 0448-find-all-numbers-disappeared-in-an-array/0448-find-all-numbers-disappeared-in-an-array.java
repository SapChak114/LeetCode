class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int i = 0; i<n; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }

        return ans;
    }
}