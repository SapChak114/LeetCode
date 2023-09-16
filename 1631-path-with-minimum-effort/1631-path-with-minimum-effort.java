class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        q.add(new int[]{0,0,0});
        
        int[][] dist = new int[n][m];
        
        for(int[] a : dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        
        dist[0][0] = 0;
        
        while(!q.isEmpty()){
            int[] node = q.poll();
            int dis = node[0];
            int row = node[1];
            int col = node[2];
            
            if(row==n-1 && col == m-1){
                return dis;
            }
            
            for(int i = 0; i<dirX.length; i++){
                int r = row + dirX[i];
                int c = col + dirY[i];
                if(r<0 || r>=n || c<0 || c>=m) continue;
                
                int newDist = Math.abs(heights[r][c] - heights[row][col]);
                int nextDist = Math.max(dis,newDist);
                
                if(nextDist<dist[r][c]){
                    dist[r][c] = nextDist;
                    q.add(new int[]{nextDist,r,c});
                }
            }
        }
        
        return 0;
    }
}