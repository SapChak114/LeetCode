class Solution {
    int[][] dp;
    int[] nums;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        dp = new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        return rec(0,n-1)>=0;
    }
    
    int rec(int left, int right){
        if(left == right){
            return nums[left];
        }
        
        if(dp[left][right]!=-1) return dp[left][right];
        
        int leftTake = nums[left] - rec(left+1,right);
        int rightTake = nums[right] - rec(left,right-1);
        
        return dp[left][right] = Math.max(leftTake,rightTake);
    }
}