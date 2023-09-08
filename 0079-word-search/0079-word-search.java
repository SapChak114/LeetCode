class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                 if(dfs(i,j,board,word,0,vis)) return true;
            }
        }
        
        return false;
    }
    
    boolean dfs(int i, int j, char[][] board, String word, int pos, boolean[][] vis){
        if(pos==word.length()){
            return true;
        }
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(pos)!=board[i][j] || vis[i][j]){
            return false;
        }
        
        vis[i][j]=true;
        for(int k = 0; k<dirX.length; k++){
            int r = i + dirX[k];
            int c = j + dirY[k];
            if(dfs(r,c,board,word,pos+1,vis)) return true;
        }
        vis[i][j]=false;
        return false;
    }
}