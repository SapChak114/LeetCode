class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums,target,false),find(nums,target,true)};
    }

    int find(int[] nums, int target, boolean flag){
        int l = 0, r = nums.length-1, ans = -1;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            
            if(nums[mid]==target){
                ans = mid;
                if(flag) l = mid + 1;
                else r = mid - 1;
            }
            else if(nums[mid]<target){
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }
        
        return ans;
    }
}