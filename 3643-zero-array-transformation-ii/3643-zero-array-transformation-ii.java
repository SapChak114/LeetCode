class Solution {
    public int minZeroArray(int[] nums, int[][] qr) {
        int n = nums.length;
        int low = -1, high = qr.length + 1;

        boolean isZeroArray = true;
        for (int num : nums) {
            if (num != 0) {
                isZeroArray = false;
                break;
            }
        }
        if (isZeroArray) {
            return 0; // No queries are needed.
        }

        while (low < high) {
            int h = high+low >> 1;
            if (solve(nums, qr, h)) {
                high = h;
            } else {
                low = h + 1;
            }
        }

        return high > qr.length ? -1 : high;
    }

    boolean solve(int[] nums, int[][] qr, int h) {
        int n = nums.length;
        long[] count = new long[n+1];
        
        for (int i = 0; i<h; i++) {
            int[] q = qr[i];
            count[q[0]] += q[2];
            count[q[1] + 1] -= q[2];
        }

        for (int i = 1; i<n; i++) {
            count[i] += count[i-1]; 
        }

        for (int i = 0; i<n; i++) {
            if (nums[i] > count[i]) {
                return false;
            }
        }

        return true;
    }
}