class Solution {
    int mod = (int)1e9 + 7;
    int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high+1];
        Arrays.fill(dp,-1);
        int count = 0;
        for(int i = low; i<=high; i++){
            count +=dfs(i,one,zero);
            count %= mod;
        }
        return count;
    }
    
    int dfs(int total, int one, int zero){
        if(total==0){
            return 1;
        }
        if(total<0){
            return 0;
        }
        if(dp[total]!=-1) return dp[total];
        
        int way1 = dfs(total-one,one,zero)%mod;
        int way2 = dfs(total-zero,one,zero)%mod;
        int way = (way1 + way2)%mod;
        return dp[total]=way;
    }
}