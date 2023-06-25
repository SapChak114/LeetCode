class Solution {
    Map<Integer,Integer> map;
    int[] nums;
    public int combinationSum4(int[] nums, int target) {
        this.map = new HashMap<>();
        this.nums = nums;
        return dfs(target);
    }
    
    int dfs(int target){
        if(target<0) return 0;
        if(target==0) return 1; 
        
        int key = target;
        if(map.containsKey(key)) return map.get(key);
        
        int ways = 0;
        for(int i = 0; i < nums.length; i++){
            ways += dfs(target - nums[i]);
        }
        
        map.put(key,ways);
        
        return ways;
    }
}