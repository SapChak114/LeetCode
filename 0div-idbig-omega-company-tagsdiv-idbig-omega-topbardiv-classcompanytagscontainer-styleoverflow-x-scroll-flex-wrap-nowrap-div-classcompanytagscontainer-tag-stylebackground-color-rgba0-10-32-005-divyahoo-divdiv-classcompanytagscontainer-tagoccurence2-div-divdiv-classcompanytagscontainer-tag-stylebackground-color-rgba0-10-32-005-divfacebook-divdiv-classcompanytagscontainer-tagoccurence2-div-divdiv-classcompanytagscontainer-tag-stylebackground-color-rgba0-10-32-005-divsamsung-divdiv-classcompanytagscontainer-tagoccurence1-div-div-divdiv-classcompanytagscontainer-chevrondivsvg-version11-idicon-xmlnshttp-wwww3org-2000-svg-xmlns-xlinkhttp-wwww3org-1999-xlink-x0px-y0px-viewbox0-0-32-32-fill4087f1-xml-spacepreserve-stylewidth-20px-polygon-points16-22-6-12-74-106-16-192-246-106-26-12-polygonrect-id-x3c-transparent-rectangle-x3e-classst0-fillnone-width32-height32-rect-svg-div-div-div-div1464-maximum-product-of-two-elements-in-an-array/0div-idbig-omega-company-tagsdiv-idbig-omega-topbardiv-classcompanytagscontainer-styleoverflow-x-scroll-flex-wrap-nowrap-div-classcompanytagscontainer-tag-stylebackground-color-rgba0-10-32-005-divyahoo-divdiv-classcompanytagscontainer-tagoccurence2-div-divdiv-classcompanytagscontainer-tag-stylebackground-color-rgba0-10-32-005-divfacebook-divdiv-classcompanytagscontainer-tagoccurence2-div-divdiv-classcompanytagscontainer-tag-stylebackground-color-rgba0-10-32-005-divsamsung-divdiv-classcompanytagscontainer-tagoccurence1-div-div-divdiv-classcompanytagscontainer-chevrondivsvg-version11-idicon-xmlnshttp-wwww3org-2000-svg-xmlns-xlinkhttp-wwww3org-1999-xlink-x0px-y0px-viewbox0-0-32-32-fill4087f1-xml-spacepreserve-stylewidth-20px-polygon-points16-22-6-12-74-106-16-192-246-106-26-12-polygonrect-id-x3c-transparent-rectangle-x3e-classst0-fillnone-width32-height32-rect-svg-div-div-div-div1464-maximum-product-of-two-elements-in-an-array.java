class Solution {
    public int maxProduct(int[] nums) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE-1, n = nums.length;
        
        for(int i = 0; i<n; i++){
            if(nums[i]>largest){
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i]>secondLargest){
                secondLargest = nums[i];
            }
        }
        
        return (largest-1)*(secondLargest-1);
    }
}