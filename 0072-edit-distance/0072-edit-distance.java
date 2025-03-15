class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        int[][] cache = new int[n+1][m+1];

        for (int j = 0; j<=m; j++) {
            cache[n][j] = m - j;
        }

        for (int i = 0; i<=n; i++) {
            cache[i][m] = n-i;
        }

        for (int i = n-1; i>=0; i--) {
            for (int j = m-1; j>=0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cache[i][j] = cache[i+1][j+1];
                } else {
                    cache[i][j] = 1 + Math.min(cache[i][j+1], Math.min(cache[i+1][j], cache[i+1][j+1]));
                }
            }
        }

        return cache[0][0];
    }
}