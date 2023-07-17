class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int res = 1;
        for(int e : arr){
            ans = map.getOrDefault(e-diff,0);
            map.put(e,ans+1);
            res = Math.max(res,map.get(e));
        }
        
        return res;
    }
}