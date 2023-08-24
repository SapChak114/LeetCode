class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num = board[i][j];
                String rowKey = "r"+i+"-"+num;
                String colKey = "c"+j+"0"+num;
                String boxKey = "r"+(i/3)+"c"+(j/3)+"-"+num;
                
                for(String key :Arrays.asList(rowKey,colKey,boxKey)){
                    if(set.contains(key)) return false;
                    set.add(key);
                }
            }
        }
        
        return true;
        
    }
}