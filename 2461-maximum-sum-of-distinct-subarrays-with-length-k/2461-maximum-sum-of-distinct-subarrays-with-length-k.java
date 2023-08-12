class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, ans = 0;
        int n = nums.length, l = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<k; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum += (long)nums[i];
        }
        
        if(map.size()==k){
            ans = sum;
        }
        
        for(int i = k; i<n; i++){
            sum += (long)nums[i];
            sum -= (long)nums[l];
            
            map.put(nums[l],map.getOrDefault(nums[l],0)-1);
            if(map.get(nums[l])==0){
                map.remove(nums[l]);
            }
            
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            l++;
            
            if(map.size()==k){
                ans = Math.max(ans,sum);
            }
        }
        
        return ans;
    }
}