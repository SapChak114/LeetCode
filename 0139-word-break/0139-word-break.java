class Solution {
    Set<String> vis;
    Map<Integer,Boolean> dp;
    String s;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        vis = new HashSet<>(wordDict);
        dp = new HashMap<>();
        this.s = s;
        this.n = s.length();
        return rec(0);
    }
    
    boolean rec(int idx){
        if(idx==n){
            return true;
        }
        
        if(dp.containsKey(idx)) return dp.get(idx);
        
        boolean canBreak = false;
        
        for(int i = idx + 1; i<=n; i++){
            String subw = s.substring(idx,i);
            if(vis.contains(subw)){
                canBreak = canBreak || rec(i);
            }
        }
        
        dp.put(idx,canBreak);
        
        return canBreak;
    }
}