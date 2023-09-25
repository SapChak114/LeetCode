class Solution {
    public int majorityElement(int[] nums) {
        int c = 0, m= 0;
        
        for(int n : nums){
            if(c==0) m=n;
            if(m==n) c++;
            else c--;
        }
        
        return m;
    }
}