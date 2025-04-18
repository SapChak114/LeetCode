class Solution {
    int MOD = (int)1e9 + 7;
    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        long s1 = 0, s2 = 0, res = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                s1 += nums1[i++];
            } else if(nums1[i] > nums2[j]) {
                s2 += nums2[j++];
            } else {
                res += Math.max(s1, s2) + nums1[i];
                res %= MOD;
                s1 = 0;
                s2 = 0;
                i++;
                j++;
            }
        }

        while (i < n) {
            s1 += nums1[i++];
        }

        while (j < m) {
            s2 += nums2[j++];
        }

        res += Math.max(s1, s2);
        res %= MOD;

        return (int)res;
    }
}