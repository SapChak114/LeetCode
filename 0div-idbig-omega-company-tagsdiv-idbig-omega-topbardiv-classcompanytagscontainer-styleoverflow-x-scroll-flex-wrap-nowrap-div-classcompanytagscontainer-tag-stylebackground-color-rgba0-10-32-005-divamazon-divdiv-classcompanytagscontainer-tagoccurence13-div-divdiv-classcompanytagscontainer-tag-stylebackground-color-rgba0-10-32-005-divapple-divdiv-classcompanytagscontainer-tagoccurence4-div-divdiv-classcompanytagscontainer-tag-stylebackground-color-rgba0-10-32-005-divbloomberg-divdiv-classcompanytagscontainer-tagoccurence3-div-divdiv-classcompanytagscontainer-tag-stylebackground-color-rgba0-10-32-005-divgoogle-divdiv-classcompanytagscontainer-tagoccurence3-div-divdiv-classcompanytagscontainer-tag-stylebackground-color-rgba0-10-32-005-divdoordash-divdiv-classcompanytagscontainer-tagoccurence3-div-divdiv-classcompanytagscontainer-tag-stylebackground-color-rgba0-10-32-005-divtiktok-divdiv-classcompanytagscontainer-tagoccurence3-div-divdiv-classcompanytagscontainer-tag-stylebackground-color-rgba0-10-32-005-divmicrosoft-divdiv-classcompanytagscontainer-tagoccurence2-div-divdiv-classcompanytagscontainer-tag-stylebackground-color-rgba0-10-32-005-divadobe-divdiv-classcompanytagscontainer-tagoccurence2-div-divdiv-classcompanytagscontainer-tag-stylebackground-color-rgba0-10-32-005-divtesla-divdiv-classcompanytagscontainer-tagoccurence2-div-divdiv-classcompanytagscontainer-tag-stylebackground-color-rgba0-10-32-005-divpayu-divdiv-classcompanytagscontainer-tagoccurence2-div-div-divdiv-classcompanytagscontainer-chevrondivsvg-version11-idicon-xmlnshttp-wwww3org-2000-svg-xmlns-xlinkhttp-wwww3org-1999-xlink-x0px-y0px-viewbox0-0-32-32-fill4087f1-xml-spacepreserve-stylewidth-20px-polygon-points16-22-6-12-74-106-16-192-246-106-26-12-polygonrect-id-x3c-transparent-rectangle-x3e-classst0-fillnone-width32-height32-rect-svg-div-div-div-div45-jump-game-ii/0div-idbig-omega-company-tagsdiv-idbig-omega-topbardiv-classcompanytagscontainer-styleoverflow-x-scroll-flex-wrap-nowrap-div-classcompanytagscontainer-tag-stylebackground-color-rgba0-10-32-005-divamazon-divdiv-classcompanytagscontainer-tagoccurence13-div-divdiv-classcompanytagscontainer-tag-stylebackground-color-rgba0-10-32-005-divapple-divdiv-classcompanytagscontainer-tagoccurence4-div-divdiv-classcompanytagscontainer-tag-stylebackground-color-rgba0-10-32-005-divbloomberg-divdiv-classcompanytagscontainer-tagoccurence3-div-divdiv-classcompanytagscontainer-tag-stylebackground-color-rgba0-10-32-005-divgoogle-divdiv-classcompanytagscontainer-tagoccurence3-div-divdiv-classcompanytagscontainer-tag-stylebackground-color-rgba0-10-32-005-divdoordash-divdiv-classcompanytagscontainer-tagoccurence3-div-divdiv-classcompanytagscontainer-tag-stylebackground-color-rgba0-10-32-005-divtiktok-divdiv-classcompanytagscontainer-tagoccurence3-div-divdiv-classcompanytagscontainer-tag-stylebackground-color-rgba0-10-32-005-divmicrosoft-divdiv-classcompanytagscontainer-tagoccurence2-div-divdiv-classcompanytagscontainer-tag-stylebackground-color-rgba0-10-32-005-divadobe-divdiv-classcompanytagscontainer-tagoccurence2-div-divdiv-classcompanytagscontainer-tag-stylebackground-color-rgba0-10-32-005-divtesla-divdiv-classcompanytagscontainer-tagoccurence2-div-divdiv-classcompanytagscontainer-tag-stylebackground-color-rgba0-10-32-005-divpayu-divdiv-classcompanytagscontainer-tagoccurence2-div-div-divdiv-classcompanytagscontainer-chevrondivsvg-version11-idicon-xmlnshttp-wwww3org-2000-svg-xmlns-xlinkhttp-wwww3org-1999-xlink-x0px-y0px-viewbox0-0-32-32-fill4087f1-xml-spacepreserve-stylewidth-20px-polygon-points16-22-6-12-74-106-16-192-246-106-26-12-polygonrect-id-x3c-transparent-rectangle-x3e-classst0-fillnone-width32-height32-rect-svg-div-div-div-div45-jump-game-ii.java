class Solution {
    public int jump(int[] nums) {
        int jump = 0, curr = 0, max = 0, n = nums.length;
        
        for(int i = 0; i<n-1; i++){
            max = Math.max(max,i+nums[i]);
            if(i==curr){
                curr = max;
                jump++;
            }
        }
        
        return jump;
    }
    
    
}