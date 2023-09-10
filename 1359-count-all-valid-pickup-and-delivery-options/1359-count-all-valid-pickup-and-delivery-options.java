class Solution {
    int mod = (int)1e9 + 7;
    Integer[][] dp;
//     public int countOrders(int n) {
//         long ans = 1;
//         for(int i = 1; i<=n*2; i++){
//             ans *= i;
//             if(i%2==0) ans /= 2;
//             ans %= mod;
//         }
        
//         return (int)ans;
//     }
    public int countOrders(int n) {
        dp=new Integer[n+1][n+1];
        return rec(n,n);
    }
    
    int rec(int pickup, int drop){
        if(pickup<0 || drop<pickup || drop<0){
            return 0;
        }
        if(pickup==0 && drop==0){
            return 1;
        }
        if(dp[pickup][drop]!=null) return dp[pickup][drop];
        long temp = (1L*(pickup%mod)*(rec(pickup-1,drop)%mod))%mod;
        temp += ((1L*(drop-pickup)%mod)*(rec(pickup,drop-1))%mod)%mod;
        temp %=mod;
        return dp[pickup][drop] = (int)temp;
        
    }
}
