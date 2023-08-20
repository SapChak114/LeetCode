class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return rec(0,s);    
    }
    
    int rec(int idx, String s){
        if(idx>=s.length()){
            return 1;
        }
        
        if(dp[idx]!=null) return dp[idx];
        
        int ans = 0, op1 = s.charAt(idx)-'0', op2 = 0;
        
        if(idx<s.length()-1){
            op2 = op1*10 + s.charAt(idx+1) - '0';
        }
        
        if(op1>0)  ans += rec(idx+1,s);
        if(op1>0 && op2>0 &&  op2<=26) ans += rec(idx+2,s);
        
        return dp[idx] = ans;
    }
}