class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        double res = helper(x, Math.abs((long)n));
        
        return (n >= 0) ? res: 1/res;
    }
    
    double helper(double x, long n){
        if(n==0) return 1;
        
        double res = helper(x,n/2);
        res = res * res;
        
        return (n%2==0)?res:(x*res);
    }
}