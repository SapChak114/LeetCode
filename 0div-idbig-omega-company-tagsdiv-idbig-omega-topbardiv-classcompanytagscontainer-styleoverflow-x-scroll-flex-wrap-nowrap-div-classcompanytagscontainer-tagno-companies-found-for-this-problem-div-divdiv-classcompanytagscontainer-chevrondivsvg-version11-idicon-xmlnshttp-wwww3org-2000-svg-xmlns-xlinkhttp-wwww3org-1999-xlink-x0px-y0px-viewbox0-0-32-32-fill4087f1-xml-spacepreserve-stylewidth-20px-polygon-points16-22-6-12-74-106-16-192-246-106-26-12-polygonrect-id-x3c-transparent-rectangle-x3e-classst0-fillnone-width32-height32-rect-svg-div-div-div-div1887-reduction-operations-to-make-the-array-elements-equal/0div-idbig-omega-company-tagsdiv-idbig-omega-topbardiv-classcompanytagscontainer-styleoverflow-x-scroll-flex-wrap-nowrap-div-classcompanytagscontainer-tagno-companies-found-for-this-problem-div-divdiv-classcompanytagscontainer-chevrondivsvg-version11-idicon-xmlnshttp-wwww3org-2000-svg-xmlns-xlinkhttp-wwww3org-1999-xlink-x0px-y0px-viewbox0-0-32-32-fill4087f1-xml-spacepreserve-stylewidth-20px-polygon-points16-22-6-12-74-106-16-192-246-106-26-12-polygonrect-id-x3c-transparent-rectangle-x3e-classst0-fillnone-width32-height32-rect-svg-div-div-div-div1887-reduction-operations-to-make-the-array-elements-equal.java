class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int present = nums[0];
        int n = nums.length, ans = 0;
        
        for(int i = 1; i<n; i++){
            if(present != nums[i]){
                ans += n - i;
                present = nums[i];
            }
        }
        
        return ans;
    }
}