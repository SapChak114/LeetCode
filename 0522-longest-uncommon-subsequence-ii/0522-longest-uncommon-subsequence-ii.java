class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int res = -1;

        for (int i = 0; i<n; i++) {
            boolean flag = false;
            for (int j = 0; j<n; j++) {
                if (i != j && isSubSequence(strs[i], strs[j])) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }

    boolean isSubSequence(String a, String b) {
        int i = 0, j = 0, n = a.length(), m = b.length();

        while (i < n && j < m) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == n;
    }
}