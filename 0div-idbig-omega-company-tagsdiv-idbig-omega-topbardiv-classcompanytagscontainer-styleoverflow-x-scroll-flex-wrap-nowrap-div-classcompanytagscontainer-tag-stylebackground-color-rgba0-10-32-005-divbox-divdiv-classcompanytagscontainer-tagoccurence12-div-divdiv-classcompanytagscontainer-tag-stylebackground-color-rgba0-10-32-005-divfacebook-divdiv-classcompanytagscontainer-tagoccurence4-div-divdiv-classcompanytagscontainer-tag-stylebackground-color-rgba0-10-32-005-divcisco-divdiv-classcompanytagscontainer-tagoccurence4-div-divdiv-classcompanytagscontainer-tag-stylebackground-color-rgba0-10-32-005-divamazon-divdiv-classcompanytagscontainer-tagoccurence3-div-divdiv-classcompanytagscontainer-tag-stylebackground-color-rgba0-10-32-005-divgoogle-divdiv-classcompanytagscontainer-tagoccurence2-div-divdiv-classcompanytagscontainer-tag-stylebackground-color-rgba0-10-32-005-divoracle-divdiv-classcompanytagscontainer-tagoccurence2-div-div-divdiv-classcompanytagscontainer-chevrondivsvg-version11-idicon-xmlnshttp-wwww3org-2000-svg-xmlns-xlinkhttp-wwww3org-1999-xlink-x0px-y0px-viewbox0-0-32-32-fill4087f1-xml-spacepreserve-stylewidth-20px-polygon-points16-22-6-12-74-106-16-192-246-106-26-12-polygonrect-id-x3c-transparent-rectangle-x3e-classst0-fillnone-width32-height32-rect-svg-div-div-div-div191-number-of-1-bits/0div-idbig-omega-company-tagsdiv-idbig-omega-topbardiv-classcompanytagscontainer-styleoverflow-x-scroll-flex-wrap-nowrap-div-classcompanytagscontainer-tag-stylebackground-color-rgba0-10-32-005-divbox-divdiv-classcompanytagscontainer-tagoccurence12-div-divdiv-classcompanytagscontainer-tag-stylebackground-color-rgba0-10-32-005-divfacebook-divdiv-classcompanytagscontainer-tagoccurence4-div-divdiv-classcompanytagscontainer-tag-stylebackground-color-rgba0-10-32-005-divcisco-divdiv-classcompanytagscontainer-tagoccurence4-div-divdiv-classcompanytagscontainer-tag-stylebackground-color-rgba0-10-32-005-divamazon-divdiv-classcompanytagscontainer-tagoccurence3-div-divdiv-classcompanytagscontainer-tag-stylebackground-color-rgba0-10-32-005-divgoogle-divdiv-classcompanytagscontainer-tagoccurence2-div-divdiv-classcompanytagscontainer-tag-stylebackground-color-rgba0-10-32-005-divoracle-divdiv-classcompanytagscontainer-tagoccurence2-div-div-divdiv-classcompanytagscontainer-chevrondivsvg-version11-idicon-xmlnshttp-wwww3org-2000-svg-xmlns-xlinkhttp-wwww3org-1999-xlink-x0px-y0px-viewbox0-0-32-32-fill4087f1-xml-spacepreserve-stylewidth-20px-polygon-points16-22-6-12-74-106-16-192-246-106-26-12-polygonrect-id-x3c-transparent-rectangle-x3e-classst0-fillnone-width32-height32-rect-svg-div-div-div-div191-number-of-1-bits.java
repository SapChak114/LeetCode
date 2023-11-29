public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 31; i>=0; i--){
            ans += (n>>i)&1;
        }
        
        return ans;
    }
}