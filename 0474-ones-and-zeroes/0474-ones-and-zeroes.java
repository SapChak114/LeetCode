class Solution {
    Map<String, Integer> dp;
    String[] strs;
    int k;
    public int findMaxForm(String[] strs, int m, int n) {
        this.dp = new HashMap<>();
        this.strs = strs;
        this.k = strs.length;
        return dfs(0, m, n);
    }

    int dfs(int i, int m, int n) {
        if (i == k) {
            return 0;
        }

        String key = i + "-" + m + "-" + n;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        
        int res = dfs(i + 1, m, n);

        int mCount = 0, nCount = 0;
        for (int l = 0; l<strs[i].length(); l++) {
            if (strs[i].charAt(l) == '0') {
                mCount++;
            } else {
                nCount++;
            }
        }

        if (mCount <= m && nCount <= n) {
            res = Math.max(res, 1 + dfs(i+1, m - mCount, n - nCount));
        }
        
        dp.put(key, res);

        return res;
    }
}