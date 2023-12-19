class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int n = img.length;
        int m = img[0].length;
        
        int[][] ans = new int[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int total = 0, count = 0;
                for(int dx= -1; dx<2; dx++){
                    for(int dy=-1; dy<2; dy++){
                        int r = i + dx;
                        int c = j + dy;
                        if(check(r,c,img)){
                            count++;
                            total += img[r][c];
                        }
                    }
                }
                ans[i][j] = total/count;
            }
        }
        
        return ans;
    }
    
    boolean check(int i, int j, int[][] img){
        int n = img.length;
        int m = img[0].length;
        if(i>=0 && i<n && j>=0 && j<m) return true;
        return false;
    }
}