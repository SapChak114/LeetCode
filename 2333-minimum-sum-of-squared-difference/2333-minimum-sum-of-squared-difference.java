class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, maxDiff = 0;

        int[] diff = new int[n];
        for (int i = 0; i<n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long[] countDiff = new long[maxDiff+1];
        for (int d : diff) {
            countDiff[d]++;
        }

        int currDiff = maxDiff;
        long K = k1 + k2;
        while (currDiff > 0 && K > 0) {
            long countOps = Math.min(countDiff[currDiff], K);
            countDiff[currDiff] -= countOps;
            countDiff[currDiff-1] += countOps;
            K -= countOps;
            currDiff--;
        }

        long res = 0;
        for (int d = maxDiff; d>=0; d--) {
            res += countDiff[d] * d * d;
        }

        return res;
    }
}