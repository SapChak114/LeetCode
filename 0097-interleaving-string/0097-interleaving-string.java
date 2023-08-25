class Solution {
    String s1, s2, s3;
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return rec(0,0,0);
    }
    
    boolean rec(int i, int j, int k){
        if(k==s3.length()){
            return true;
        }
        
        if(dp[i][j][k]!=null) return dp[i][j][k];
        
        boolean ans = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            ans = ans | rec(i+1,j,k+1);
        } 
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            ans = ans | rec(i,j+1,k+1);
        }
        
        return dp[i][j][k] = ans;
    }
}