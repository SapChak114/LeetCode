class Solution {
    public int jump(int[] nums) {
        int currEnd = 0, maxEnd = 0, n = nums.length, jump = 0;
        
        for(int i = 0; i<n-1; i++){
            maxEnd = Math.max(maxEnd,i+nums[i]);
            if(i==currEnd){
                currEnd = maxEnd;
                jump++;
            }
        }
        
        return jump;
    }
    
}