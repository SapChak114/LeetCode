class Solution {
    public int jump(int[] nums) {
        int curr = 0, jump = 0, maxJump = 0;
        
        for(int i = 0; i<nums.length-1; i++){
            maxJump = Math.max(maxJump,i+nums[i]);
            if(i==curr){
                jump++;
                curr = maxJump;
            }
        }
        
        return jump;
    }
}