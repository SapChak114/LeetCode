class Solution {
    int bisectLeft(List<Integer> nums, int targ){
        int l = 0, r = nums.size();
        
        while(l<r){
            int mid = (l+r)/2;
            
            if(nums.get(mid)<targ){
                l = mid+1;
            } else{
                r = mid;        
            }
        }
        
        return l;
    }
    
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int num : nums){
            int idx = bisectLeft(res,num);
            if(idx==res.size()){
                res.add(num);
            }
            res.set(idx,num);
        }
        
        return res.size();
    }
}