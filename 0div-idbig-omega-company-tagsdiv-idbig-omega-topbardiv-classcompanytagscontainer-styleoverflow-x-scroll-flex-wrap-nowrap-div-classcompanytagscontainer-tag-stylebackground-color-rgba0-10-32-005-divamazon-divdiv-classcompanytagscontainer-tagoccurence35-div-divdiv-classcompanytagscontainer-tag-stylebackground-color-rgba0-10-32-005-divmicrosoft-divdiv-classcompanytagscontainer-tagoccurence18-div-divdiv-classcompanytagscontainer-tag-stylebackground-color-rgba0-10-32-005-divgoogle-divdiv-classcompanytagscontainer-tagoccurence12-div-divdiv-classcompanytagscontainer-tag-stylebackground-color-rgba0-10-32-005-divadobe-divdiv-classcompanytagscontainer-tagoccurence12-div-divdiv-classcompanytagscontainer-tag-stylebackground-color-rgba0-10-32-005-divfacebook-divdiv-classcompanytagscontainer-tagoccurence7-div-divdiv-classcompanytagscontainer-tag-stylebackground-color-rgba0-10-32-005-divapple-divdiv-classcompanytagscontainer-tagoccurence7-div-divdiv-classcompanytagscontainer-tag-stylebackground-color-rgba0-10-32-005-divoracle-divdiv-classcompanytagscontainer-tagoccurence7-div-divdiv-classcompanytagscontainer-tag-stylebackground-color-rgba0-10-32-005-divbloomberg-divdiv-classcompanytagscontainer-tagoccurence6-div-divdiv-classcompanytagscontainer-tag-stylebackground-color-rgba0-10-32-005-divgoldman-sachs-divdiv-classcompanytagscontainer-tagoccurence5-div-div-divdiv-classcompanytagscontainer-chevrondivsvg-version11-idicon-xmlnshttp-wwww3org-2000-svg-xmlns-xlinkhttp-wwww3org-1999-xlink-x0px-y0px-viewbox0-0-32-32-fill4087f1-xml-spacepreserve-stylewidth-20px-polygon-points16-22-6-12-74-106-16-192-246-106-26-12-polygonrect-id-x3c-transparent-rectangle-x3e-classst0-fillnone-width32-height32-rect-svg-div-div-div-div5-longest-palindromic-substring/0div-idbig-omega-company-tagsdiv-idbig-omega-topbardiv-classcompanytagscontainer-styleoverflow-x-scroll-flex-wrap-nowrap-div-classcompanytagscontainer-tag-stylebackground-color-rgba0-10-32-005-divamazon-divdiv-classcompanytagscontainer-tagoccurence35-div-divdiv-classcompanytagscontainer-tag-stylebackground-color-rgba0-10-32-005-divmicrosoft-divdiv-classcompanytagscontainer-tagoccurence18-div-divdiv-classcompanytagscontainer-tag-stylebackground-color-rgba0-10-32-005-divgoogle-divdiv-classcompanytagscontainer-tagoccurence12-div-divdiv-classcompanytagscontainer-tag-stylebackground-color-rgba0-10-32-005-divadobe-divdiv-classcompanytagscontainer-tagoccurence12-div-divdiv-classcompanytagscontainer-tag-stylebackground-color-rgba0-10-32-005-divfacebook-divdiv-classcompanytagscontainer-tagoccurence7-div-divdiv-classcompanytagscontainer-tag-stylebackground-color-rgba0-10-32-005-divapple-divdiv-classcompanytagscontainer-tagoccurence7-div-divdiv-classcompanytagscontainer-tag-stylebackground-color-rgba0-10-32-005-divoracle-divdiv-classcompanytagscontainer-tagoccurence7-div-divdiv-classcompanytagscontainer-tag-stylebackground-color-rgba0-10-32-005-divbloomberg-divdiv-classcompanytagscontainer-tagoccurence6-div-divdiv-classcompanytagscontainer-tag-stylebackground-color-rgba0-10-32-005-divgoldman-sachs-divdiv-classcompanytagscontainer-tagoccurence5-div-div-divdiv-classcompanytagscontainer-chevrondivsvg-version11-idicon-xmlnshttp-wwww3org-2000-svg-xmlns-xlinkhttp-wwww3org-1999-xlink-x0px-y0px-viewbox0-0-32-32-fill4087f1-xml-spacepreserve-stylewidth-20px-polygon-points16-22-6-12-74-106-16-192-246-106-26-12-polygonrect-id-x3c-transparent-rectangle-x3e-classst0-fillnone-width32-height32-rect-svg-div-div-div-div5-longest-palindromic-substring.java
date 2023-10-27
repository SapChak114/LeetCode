class Solution {
    Integer[][] dp;
    public String longestPalindrome(String s) {
        dp = new Integer[s.length()+1][s.length()+1];
        rec(s,0,s.length()-1);
        int start = 0, max = 0;
        
        for(int i = 0; i<s.length(); i++){
            for(int j = s.length()-1; j>=i; j--){
                if(dp[i][j]!=null && dp[i][j]==1 && j-i+1>max){
                    start = i;
                    max = j-i+1;
                }
            }
        }
        
        return s.substring(start,start+max);
    }
    
    int rec(String s, int i, int j){
        if(i==j) return dp[i][j]=1;
        if(i>j) return 1;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        if(s.charAt(i)==s.charAt(j) && rec(s,i+1,j-1)==1){
            dp[i][j]=1;
        } else{
            dp[i][j]=0;
        }
        
        rec(s,i+1,j);
        rec(s,i,j-1);
        
        return dp[i][j];
    }
}