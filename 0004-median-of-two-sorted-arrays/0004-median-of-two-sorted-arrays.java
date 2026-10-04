class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int inf = Integer.MAX_VALUE;
        int[] A = nums1, B = nums2;
        int n = A.length, m = B.length;
        int total = n + m;

        if (n > m) {
            return findMedianSortedArrays(B, A);
        }

        int l = 0, r = n;

        while (l <= r) {
            int i = (l + r) / 2; // A
            int j = (total + 1) / 2 - i; // B

            double Aleft = (i == 0) ? -inf : A[i - 1];
            double Aright = (i == n) ? inf : A[i];
            double Bleft = (j == 0) ? -inf : B[j - 1];
            double Bright = (j == m) ? inf : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                } else {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0D;
                }
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return 0.0;
    }
}