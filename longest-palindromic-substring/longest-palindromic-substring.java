class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        rec(dp,s,0,s.length()-1);
        int max=0;
        int start = 0;
        
        for(int i = 0; i<s.length(); i++){
            for(int j = s.length()-1; j>=i; j--){
                if(dp[i][j]==1 && max<j-i+1){
                    max=j-i+1;
                    start=i;
                }
            }
        }
        
        return s.substring(start,start+max);
    }
    
    int rec(int[][] dp, String s, int i, int j){
        if(i==j){
            return dp[i][j]=1;
        }
        
        if(i>j){
            return 1;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(s.charAt(i)==s.charAt(j) && rec (dp,s,i+1,j-1)==1){
            dp[i][j]=1;
        } else{
            dp[i][j]=0;
        }
        
        rec(dp,s,i+1,j);
        rec(dp,s,i,j-1);
        
        return dp[i][j];
    }
}