class Solution {
    int res;
    int n;
    Set<Integer> col;
    Set<Integer> diag;
    Set<Integer> antiDiag;
    public int totalNQueens(int n) {
        this.res = 0;
        this.n = n;
        col = new HashSet<>();
        diag = new HashSet<>();
        antiDiag = new HashSet<>();
        backTrack(0);
        return res;
    }
    
    void backTrack(int r){
        if(r==n){
            res++;
            return;
        }
        
        for(int c = 0; c<n; c++){
            if(col.contains(c) || diag.contains(r+c) || antiDiag.contains(r-c)){
                continue;
            }
            col.add(c);
            diag.add(r+c);
            antiDiag.add(r-c);
            backTrack(r+1);
            col.remove(c);
            diag.remove(r+c);
            antiDiag.remove(r-c);
        }
    }
}