class Solution {
    int n,m;
    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j]=='O' && (i==0 || i==n-1 || j==0 || j==m-1)){
                    dfs(board,i,j);
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    
    void dfs(char[][] board, int i, int j){
        if(i>=n || j<0 || j>=m || i<0 || board[i][j]!='O') return;
        
        board[i][j]='#';
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i,j-1);
    }
}