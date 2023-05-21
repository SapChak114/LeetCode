class Pair{
    int a;
    int b;
    
    public Pair(int a, int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
    
        boolean flag = false;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(A[i][j]==1){
                    dfs(A,i,j,q,vis);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        
        int step = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                Pair p = q.poll();
                for(int i = 0; i<dirX.length; i++){
                    int x = p.a + dirX[i];
                    int y = p.b + dirY[i];
                    if(x<0 || y<0 || x>=m || y>=n || vis[x][y]) continue;
                    if(A[x][y]==1) return step;
                    q.add(new Pair(x,y));
                    vis[x][y]=true;
                }
            }
            step++;
        }
        
        return -1;
    }
    
    void dfs(int[][] A, int i, int j, Queue<Pair> q, boolean[][] vis){
        int m = A.length;
        int n = A[0].length;
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j] || A[i][j]==0) return;
        
        vis[i][j]=true;
        q.add(new Pair(i,j));
        for(int a = 0; a<dirX.length; a++){
            int x = dirX[a] + i;
            int y = dirY[a] + j;
            dfs(A,x,y,q,vis);
        }
    }
}