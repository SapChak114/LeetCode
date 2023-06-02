class Solution {
    int count = 0;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int max = Integer.MIN_VALUE;
        boolean[] v = new boolean[n];
        int ans = 0;
        for(int i = 0; i<n; i++){
            count = 0;
            max = Math.max(max,dfs(i,bombs,new boolean[n]));
            ans = Math.max(ans,count);
        }
        return ans;
    }
    
    int dfs(int idx, int[][] bombs, boolean[] v){
        count++;
        v[idx] = true;
        
        int n = bombs.length;
        
        for(int i = 0; i<n; i++){
            if(!v[i] && inRange(bombs[idx],bombs[i])){
                v[i] = true;
                dfs(i,bombs,v);
            }
        }
        
        return count;
    }
    
    boolean inRange(int[] a, int[] b){
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx*dx + dy*dy <= r*r;
    }
}