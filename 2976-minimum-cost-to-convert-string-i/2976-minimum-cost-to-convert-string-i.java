class Solution {
    final long INF = Long.MAX_VALUE/2;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];

        for (int i = 0; i<26; i++) {
            for (int j = 0; j<26; j++) {
                dist[i][j] = i == j ? 0 : INF;
            }
        }

        for (int i = 0; i<original.length; i++) {
            int a = original[i]-'a';
            int b = changed[i]-'a';
            dist[a][b] = Math.min(dist[a][b], cost[i]);
        }

        flyodWarshal(dist);

        long totalDist = 0;
        int n = source.length();
        for (int i = 0; i<n; i++) {
            int a = source.charAt(i)-'a';
            int b = target.charAt(i)-'a';
            if (dist[a][b] == INF) {
                return -1;
            }
            totalDist += dist[a][b];
        }

        return totalDist;
    }

    void flyodWarshal(long[][] dist) {
        
        for (int k = 0; k<26; k++) {
            for (int i = 0; i<26; i++) {
                for (int j = 0; j<26; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF){
                        continue;
                    } 
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}