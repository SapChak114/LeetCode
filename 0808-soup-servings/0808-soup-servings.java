class Solution {
    double[][] dp;
    public double soupServings(int n) {
        if(n >= 5000) return 1.0;
        dp = new double[n+1][n+1];
        for(double[] d : dp) Arrays.fill(d,-1);
        
        return rec(n,n);
    }
    
    double rec(int A, int B){
        if(A<=0 && B<=0){
            return 0.5;
        }
        
        if(A<=0){
            return 1.0;
        }
        
        if(B<=0){
            return 0;
        }
        
        if(dp[A][B]!=-1) return dp[A][B];
        
        double prob = 0;
        
        prob += 0.25 * rec(A-100,B);
        prob += 0.25 * rec(A-75,B-25);
        prob += 0.25 * rec(A-50,B-50);
        prob += 0.25 * rec(A-25,B-75);
        
        return dp[A][B] = prob;
        
    }
}