class Solution {
    int[] dirX = {0,1,-1,0};
    int[] dirY = {1,0,0,-1};
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        int[][] dis = new int[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j]==0){
                    mat[i][j]=-1;
                    row.add(i);
                    col.add(j);
                    dist.add(0);
                }
            }
        }
        
        while(!row.isEmpty()){
            int x = row.poll();
            int y = col.poll();
            int d = dist.poll();
            dis[x][y]=d;
            for(int i = 0; i<dirX.length; i++){
                int r = x + dirX[i];
                int c = y + dirY[i];
                
                if(r<0 || r>=n || c<0 || c>=m || mat[r][c]!=1){
                    continue;
                }
                mat[r][c]=-1;
                row.add(r);
                col.add(c);
                dist.add(d+1);
            }
        }
        
        return dis;
    }
}