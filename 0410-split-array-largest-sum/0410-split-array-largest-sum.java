class Solution {
    int[] nums;
    int  n;
    Integer[][] dp;
    public int splitArray(int[] nums, int k) {
        this.n = nums.length;
        this.dp = new Integer[n][k+1];
        this.nums = nums;
        //this.k = k;
        return dfs(0, k);
    }
    
    int dfs(int idx, int k) {
        if (idx == n) {
            return -(int)1e8 + 2;
        }
        if (k == 1) {
            long sum = 0;
            for (int i = idx; i<n; i++) {
                sum += nums[i];
            }
            //System.out.println("base i : "+idx+" nums "+ sum);
            return (int)sum;
        }
        //System.out.println(idx+" idx "+k);
        if (dp[idx][k] != null) {
            return dp[idx][k];
        }
        long sum = 0, res = 0, max = (int)1e8 + 2;
        for (int i = idx; i<=n-k; i++) {
            //System.out.println(i+",");
            //System.out.println("i : "+i+" nums "+ sum);
            sum += nums[i];
            res = Math.max(sum, dfs(i+1, k-1));
            max = Math.min(max, res);
        }
        
        // 5-2+1
        // n-k+1
        return dp[idx][k] = (int)max;
    }
}


