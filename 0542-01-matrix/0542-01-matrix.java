class Pair{
    int x;
    int y;
    int dist;
    
    public Pair(int x, int y, int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
class Solution {
    int[] dirX = {0,1,-1,0};
    int[] dirY = {1,0,0,-1};
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        int[][] dist = new int[n][m];
        int[][] vis = new int[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));  
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int d = p.dist;
            dist[x][y]=d;
            for(int i = 0; i<dirX.length; i++){
                int xx = x + dirX[i];
                int yy = y + dirY[i];
                
                if(xx<0 || xx>=n || yy<0 || yy>=m || vis[xx][yy]==1 || mat[xx][yy]==0){
                    continue;
                }
                vis[xx][yy]=1;
                q.add(new Pair(xx,yy,d+1));
            }
        }
        
        return dist;
    }
}