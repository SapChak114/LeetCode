class Solution {
    int ans = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] req = new int[n];
        dfs(n,requests,0,0,req);
        return ans;
    }
    
    void dfs(int n,int[][] request, int i, int l, int[] req){
        if(i==request.length){
            for(int x : req) if(x!=0) return;
            ans = Math.max(ans,l);
            return;
        }
        
        dfs(n,request,i+1,l,req);
        req[request[i][0]]++;
        req[request[i][1]]--;
        dfs(n,request,i+1,l+1,req);
        req[request[i][0]]--;
        req[request[i][1]]++;
    }
}