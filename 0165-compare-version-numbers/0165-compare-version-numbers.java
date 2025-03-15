class Solution {
    public int compareVersion(String version1, String version2) {
        String[] l1 = version1.split("\\.");
        String[] l2 = version2.split("\\.");
        int n = l1.length, m = l2.length;
        int maxLen = Math.max(n, m);
        int v1 = 0, v2 = 0;

        for (int i = 0; i<maxLen; i++) {
            if (i < n) {
                v1 = Integer.valueOf(l1[i]);
            } else {
                v1 = 0;
            }

            if (i < m) {
                v2 = Integer.valueOf(l2[i]);
            } else {
                v2 = 0;
            }

            if (v1 < v2) {
                return -1;
            }
            if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }
}