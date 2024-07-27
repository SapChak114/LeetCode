class Solution {
    Integer[][] dp;
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        this.dp = new Integer[n+1][m+1];
        int len = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                len = Math.max(len, dfs(nums1, nums2, i, j));
            }
        }

        return len;
    }

    int dfs(int[] nums1, int[] nums2, int i, int j) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int len = 0;
        if (nums1[i] == nums2[j]) {
            len = 1 + dfs(nums1, nums2, i+1, j+1);
        } else {
            dfs(nums1, nums2, i+1, j);
            dfs(nums1, nums2, i, j+1);
        }

        return dp[i][j] = len;
    }
}