class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] triplet = new int[2];
        
        triplet[0]=Integer.MAX_VALUE;
        triplet[1]=Integer.MAX_VALUE;
        
        for(int num : nums){
            if(num<=triplet[0]){
                triplet[0] = num;
            }
            else if(num<=triplet[1]){
                triplet[1] = num;
            } else{
                return true;
            }
        }
        
        return false;
    }
}