class Solution {
    Map<Integer,Integer> map;
    public int lengthOfLIS(int[] nums) {
        map = new HashMap<>();
        return dfs(nums,0,-1);
    }
    int dfs(int[] nums,int idx, int mtn){
        
        if(idx==nums.length){
            return 0;
        }
        
        if(map.containsKey(mtn)) return map.get(mtn);
        
        int take=0,dont=0;
        if(mtn==-1 || (nums[idx]>nums[mtn])){
            take = dfs(nums,idx+1,idx)+1;
        }
        dont = dfs(nums,idx+1,mtn);
        
        int result = Math.max(take,dont);
        
        map.put(mtn,result);
        
        return result;
    }
}