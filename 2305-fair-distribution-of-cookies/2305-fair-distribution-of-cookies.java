class Solution {
    int ans;
    public int distributeCookies(int[] cookies, int k) {
        int[] bags = new int[k];
        ans = Integer.MAX_VALUE;
        solve(cookies,0,k,bags);
        return ans;
    }
    
    void solve(int[] cookies,int i, int k, int[] bags){
        if(i==cookies.length){
            int max = Integer.MIN_VALUE;
            for(int bag : bags) max = Math.max(max,bag);
            ans = Math.min(ans,max);
            return;
        }
        
        for(int j = 0; j<k; j++){
            bags[j] += cookies[i];
            solve(cookies,i+1,k,bags);
            bags[j] -= cookies[i];
        }
    }
}