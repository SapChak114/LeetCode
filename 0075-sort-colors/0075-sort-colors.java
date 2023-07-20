class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, l = 0, r = n-1;
        
        while(i<=r){
            if(nums[i]==0){
                swap(nums,i,l);
                l++;
            }
            else if(nums[i]==2){
                swap(nums,i,r);
                r--;
                i--;
            }
            i++;
        }
    }
    
    void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}