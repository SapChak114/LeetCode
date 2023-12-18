class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[0];
        int b = nums[1];
        int c = nums[n-2];
        int d = nums[n-1];
        
        return (c*d) - (a*b);
    }
}