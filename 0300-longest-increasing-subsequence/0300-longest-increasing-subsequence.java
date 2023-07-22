class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i<n; i++){
            int idx = bs(res,nums[i]);
            if(idx==res.size()){
                res.add(nums[i]);
            }
            res.set(idx,nums[i]);
        }
        
        return res.size();
        
    }
    
    int bs(List<Integer> nums, int targ){
        int l = 0, r = nums.size();
        
        while(l<r){
            int mid = l + (r-l)/2;
            
            if(nums.get(mid)==targ){
                l = mid;
                break;
            }
            
            else if(nums.get(mid)<targ){
                l = mid + 1; 
            } else{
                r = mid;
            }
        }
        
        return l;
    }
}