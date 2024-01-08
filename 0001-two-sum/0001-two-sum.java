class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i = 0; i<n; i++){
            int req = target - nums[i];
            
            if(map.containsKey(req)){
                int idx1 = map.get(req);
                int idx2 = i;
                return new int[]{idx1,idx2};
            } else{
                map.put(nums[i],i);
            }
        }
        
        return new int[]{};
    }
}