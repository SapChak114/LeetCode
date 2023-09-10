class Solution {
//     int mod = (int)10e9 + 7;
//     public int countOrders(int n) {
//         long ans = 1;
//         for(int i = 1; i<=n*2; i++){
//             ans *= i;
//             if(i%2==0){
//                 ans /= 2;
//             }
//             ans %= mod;
//         }
        
//         return (int)ans;
//     }
    
    private static final long mod = 1000000007; // Define mod as a static global variable

    public int countOrders(int n) {
        Map<String, Long> dp = new HashMap<>();
        return (int)rec(n, n, dp);
    }

    long rec(long pickup, long drop, Map<String, Long> dp) {
        if (pickup < 0 || drop < pickup || drop < 0) {
            return 0L;
        }
        if (pickup == 0 && drop == 0) {
            return 1L;
        }

        String key = pickup + "," + drop;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        long temp = pickup * rec(pickup - 1, drop, dp);
        temp += (drop - pickup) * rec(pickup, drop - 1, dp);
        temp %= mod;

        dp.put(key, temp);
        return temp;
    }
}