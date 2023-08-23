class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(dfs(i,j,board,word,0)) return true;        
            }
        }
        
        return false;
    }
    
    boolean dfs(int i, int j, char[][] board, String word, int pos){
        if(pos==word.length()){
            return true;
        }
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]!=word.charAt(pos)){
            return false;
        }
        char orginal = board[i][j];
        board[i][j] = '#';
        
         for(int k = 0; k<dirX.length; k++){
             int newi = i+dirX[k];
             int newj = j+dirY[k];
             if(dfs(newi,newj,board,word,pos+1)) return true;
         }
        board[i][j] = orginal;
        
        return false;
    }
}