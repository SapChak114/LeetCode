class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Last index of non-zero elements in nums1
        int j = n - 1; // Last index of nums2
        int k = m + n - 1; // Last index of nums1 (full length)

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If any elements left in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}