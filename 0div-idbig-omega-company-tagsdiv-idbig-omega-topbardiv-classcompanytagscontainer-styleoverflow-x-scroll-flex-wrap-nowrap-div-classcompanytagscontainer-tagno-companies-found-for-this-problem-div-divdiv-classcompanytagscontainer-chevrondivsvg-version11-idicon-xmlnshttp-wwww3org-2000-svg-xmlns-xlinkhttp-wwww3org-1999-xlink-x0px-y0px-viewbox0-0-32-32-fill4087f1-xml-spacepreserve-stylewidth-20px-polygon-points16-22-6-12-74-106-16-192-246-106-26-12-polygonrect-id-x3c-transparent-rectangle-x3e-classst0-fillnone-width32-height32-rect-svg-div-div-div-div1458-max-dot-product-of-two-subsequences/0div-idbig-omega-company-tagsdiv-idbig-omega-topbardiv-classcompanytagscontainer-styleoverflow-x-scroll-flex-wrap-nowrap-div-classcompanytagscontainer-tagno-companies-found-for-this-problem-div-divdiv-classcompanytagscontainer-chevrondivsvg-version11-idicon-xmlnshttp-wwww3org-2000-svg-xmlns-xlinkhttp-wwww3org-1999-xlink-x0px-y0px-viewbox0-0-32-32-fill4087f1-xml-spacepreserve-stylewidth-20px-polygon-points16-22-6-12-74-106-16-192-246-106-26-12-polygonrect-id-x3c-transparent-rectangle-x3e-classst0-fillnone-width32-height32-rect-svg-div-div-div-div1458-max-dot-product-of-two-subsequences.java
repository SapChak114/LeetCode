class Solution {
    int[] nums1;
    int[] nums2;
    Integer[][] dp;
    int n, m;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.n = nums1.length;
        this.m = nums2.length;
        dp = new Integer[n+1][m+1];
        
        return rec(0,0);
    }
    
    int rec(int i, int j){
        if(i==n || j==m){
            return -((int)1e9+7);
        }
        
        if(dp[i][j]!=null) return dp[i][j];
        
        int takeBoth = nums1[i]*nums2[j];  
        int skipBoth = rec(i+1,j+1);
        int take1Skip2 = rec(i,j+1);
        int take2Skip1 = rec(i+1,j);
        
        int result = Math.max(takeBoth, Math.max(skipBoth+takeBoth, Math.max(take1Skip2, take2Skip1)));
        return dp[i][j] = result;
    }
}