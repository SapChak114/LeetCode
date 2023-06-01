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
    int[] dirX = {0,1,0,-1,1,-1,-1,1};
    int[] dirY = {1,0,-1,0,1,1,-1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,0,1));
        boolean[][] vis = new boolean[m][n];
        
        vis[0][0]=true;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            if(p.x==n-1 && p.y==m-1){
                return p.dist;
            }
            
            for(int i = 0; i<dirX.length; i++){
                int newX = p.x + dirX[i];
                int newY = p.y + dirY[i];
                if(newX<0 || newX>n-1 || newY<0 || newY>m-1 || grid[newX][newY]==1 || vis[newX][newY]) continue;
                q.add(new Pair(newX,newY,p.dist+1));
                vis[newX][newY]=true;
            }
        }
        
        return -1;
    }
}