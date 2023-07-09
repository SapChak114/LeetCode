class Solution {
    public int singleNumber(int[] nums) {
        int res = 0, n = nums.length;
        
        for(int i=0; i<32; i++){
            int one = 0;
            
            for(int num : nums){
                if(((num>>i)&1)==1){
                    one++;
                }
            }
            
            one %=3;
            
            if(one!=0){
                res |= 1<<i;
            }
        }
        
        return res;
    }
}