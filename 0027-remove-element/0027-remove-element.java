class Solution {
    public int removeElement(int[] nums, int val) {
        int c = 0;
        for ( int i = 0; i<nums.length; i++ ){
            if (val != nums[i]){
                int temp = nums[c];
                nums[c] = nums[i];
                nums[i] = temp;
                c++;
            }
        }
        
        return c;
    }
}