class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0, n = points.length;
        
        for(int i = 0; i<n-1; i++){
            int curX = points[i][0];
            int curY = points[i][1];
            int tarX = points[i+1][0];
            int tarY = points[i+1][1];
            
            ans += Math.max(Math.abs(curX-tarX),Math.abs(curY-tarY));
        }
        
        return ans;
    }
}