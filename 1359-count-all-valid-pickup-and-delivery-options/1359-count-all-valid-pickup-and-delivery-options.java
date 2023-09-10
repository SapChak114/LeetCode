class Solution {
    int mod = (int)1e9 + 7;
    public int countOrders(int n) {
        long ans = 1;
        for(int i = 1; i<=n*2; i++){
            ans *= i;
            if(i%2==0){
                ans /= 2;
            }
            ans %= mod;
        }
        
        return (int)ans;
    }
}

/*
2
4*3*2*1
 (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1   
 */