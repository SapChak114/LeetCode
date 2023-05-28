class Solution {
    int[][] dp;
    LinkedList<Integer> cuts;
    public int minCost(int n, int[] cutsArr) {
        cuts = new LinkedList<>();
        cuts.add(0);
        
        for(int cut : cutsArr){
            cuts.add(cut);
        }
        
        cuts.add(n);
        
        int c = cuts.size()-2;
        
        dp = new int[cuts.size()][cuts.size()];
        
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        Collections.sort(cuts);
        return rec(1,c);
    }
    
    int rec(int i, int j){
        if(i>j){
            return 0;
        }
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;        
        for(int ind = i; ind<=j; ind++){
            int res = cuts.get(j+1) - cuts.get(i-1)
                        + rec(i,ind-1) + rec(ind+1,j);
            
            ans = Math.min(ans,res);
        }
        
        return dp[i][j] = ans;
    }
}