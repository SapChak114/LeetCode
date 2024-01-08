class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, mid = 0, right = n-1;
        
        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                left++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            } else{
                swap(nums,mid,right);
                right--;
            }
        }
    
    }
    
    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}