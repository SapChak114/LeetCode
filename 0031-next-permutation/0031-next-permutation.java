import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        
        if(idx==-1){
            reverseArray(nums);
            return;
        }
        
        for(int i = nums.length-1; i>=idx; i--){
            if(nums[i]>nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        
        int start = idx+1; // index to start reversing from
        int end = nums.length; // index to stop reversing at

        for (int i = start, j = end-1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
    
    public void reverseArray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }   
    
    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}