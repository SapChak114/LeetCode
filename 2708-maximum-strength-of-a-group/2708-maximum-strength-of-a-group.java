class Solution {
    long max;
    int[] nums;
    public long maxStrength(int[] nums) {
        if(nums.length==1) return nums[0];
        this.max = 0;
        this.nums=nums;
        int pos = 0, neg = 0, z = 0;
        
        for(int n : nums){
            if(n>0) pos++;
            else if(n<0) neg++;
            else z++;
        }
        
        if(pos==0 && neg==1 && nums.length>1) return 0;
        if(z==nums.length) return 0;
        group(0,1);    
        return max;
    }
    
    void group(int i, long g){
        if(i>=nums.length){
            max = Math.max(max,g);
            return;
        }
        
        group(i+1,g*nums[i]);
        group(i+1,g);
    }
}