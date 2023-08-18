class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] link = new int[n];
        int[][] directLinks = new int[n][n];
        
        for(int[] road : roads){
            link[road[0]]++;
            link[road[1]]++;
            directLinks[road[0]][road[1]] = 1;
            directLinks[road[1]][road[0]] = 1;
        }
        
        int rank = 0;
        for(int i = 0; i<n; i++){
            for(int j = i + 1; j<n; j++){
                rank = Math.max(rank,link[i]+link[j]-directLinks[i][j]);  
            }
        }
        
        return rank;
    }
}