class Solution {
    private int[][] events;
    private int n;
    private int[][] dp;
    public int maxValue(int[][] events, int k) {
        dp = new int[events.length+1][k+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        this.events=events;
        this.n=events.length;
        return dfs(0,k);
    }
    
    int dfs(int index, int k){
        if(index==n || k==0){
            return 0;
        }
        String key = index+"-"+k;
        
        if(dp[index][k]!=-1) return dp[index][k];
        
        int dont = dfs(index+1,k);
        int value = events[index][2];
        int end = events[index][1];
        int idx = bs(events,end);
        int take = value + dfs(idx,k-1);
        
        dp[index][k]=Math.max(dont,take);
        
        return Math.max(dont,take);
    }
    
    private int bs(int[][] events, int targ){
        int l = 0, r = events.length;
        
        while(l<r){
            int mid = l + (r-l)/2;
            if(targ>=events[mid][0]){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        
        return l;
    }
}