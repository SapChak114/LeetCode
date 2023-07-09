class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0, n = nums.length;
        int left = 0, right = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            
            while(map.getOrDefault(0,0)>1){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                left++;
            }
            
            res = Math.max(res,right-left);
            
            right++;
        }
        
        return res;
    }
}