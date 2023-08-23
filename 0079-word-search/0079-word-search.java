class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j] && dfs(i,j,board,word,""+board[i][j],vis)) return true;        
            }
        }
        
        return false;
    }
    
    boolean dfs(int i, int j, char[][] board, String word, String ans, boolean[][] vis){
        if(ans.length()==word.length()){
            if(ans.equals(word)){
                return true;
            }
            return false;
        }
        vis[i][j] = true;
        
         for(int k = 0; k<dirX.length; k++){
             int newi = i+dirX[k];
             int newj = j+dirY[k];
             if(newi>=board.length || newi<0 || newj>=board[0].length || newj<0 || vis[newi][newj]){
                    continue;
             }
             if(dfs(newi,newj,board,word,ans+board[newi][newj],vis)) return true;
         }
        vis[i][j] = false;
        
        return false;
    }
}