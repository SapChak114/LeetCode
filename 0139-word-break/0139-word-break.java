class Solution {
    Set<String> vis;
    Boolean[] dp;
    String s;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        vis = new HashSet<>(wordDict);
        this.s = s;
        this.n = s.length();
        this.dp = new Boolean[n+1];
        return rec(0);
    }
    
    boolean rec(int idx){
        if(idx==n){
            return true;
        }
        
        if(dp[idx]!=null) return dp[idx];
        
        boolean canBreak = false;
        
        for(int i = idx + 1; i<=n; i++){
            String subw = s.substring(idx,i);
            if(vis.contains(subw)){
                canBreak = canBreak || rec(i);
            }
        }

        return dp[idx] = canBreak;
    }
}