class Solution {
    Set<String> set;
    int n;
    String s;
    Integer[] dp;
    public int minExtraChar(String s, String[] dict) {
        set = new HashSet<>(Arrays.asList(dict));
        n = s.length();
        this.s = s;
        dp = new Integer[n+1];
        return rec(0);
    }
    
    int rec(int start){
        if(start==n){
            return 0;
        }
        
        if(dp[start]!=null){
            return dp[start];
        }
        
        int ans = rec(start+1)+1;
        for(int end = start; end<n; end++){
            String str = s.substring(start,end+1);
            if(set.contains(str)){
                ans = Math.min(ans,rec(end+1));
            }
        }
        
        return dp[start] = ans;
    }
}