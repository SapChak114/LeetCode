class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j];
                String rowKey = "r"+i+"-"+num;
                String colKey = "c"+j+"-"+num;
                String bolKey = "r"+(i/3)+"c"+(j/3)+"-"+num;
                for(String key : Arrays.asList(rowKey, colKey, bolKey)){
                    if(hs.contains(key)) return false;
                    hs.add(key);
                }
            }
        }
        return true;
    }
}