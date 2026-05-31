class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        int val = nums[0];
        for (int i = 1; i<n; i++) {
            arr[i] *= val;
            val *= nums[i];
        }

        val = nums[n-1];
        for (int i = n-2; i>=0; i--) {
            arr[i] *= val;
            val *= nums[i];
        }

        return arr;
    }
}