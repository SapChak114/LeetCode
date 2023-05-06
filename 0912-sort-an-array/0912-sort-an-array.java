class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    void mergeSort(int[] nums, int low, int high){
        if(low>=high){
            return;
        }
        
        int mid = (low + high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    
    void merge(int[] nums, int low, int mid, int high){
        List<Integer> li = new ArrayList<>(); 
        int left = low;
        int right = mid + 1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                li.add(nums[left]);
                left++;
            } else{
                li.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            li.add(nums[left]);
            left++;
        }
        while(right<=high){
            li.add(nums[right]);
            right++;
        }
        for(int i = low; i<=high; i++){
            nums[i] = li.get(i-low);
        }
    }
    
    int[] bubbleSort(int[] nums){
        for(int i = 0; i<nums.length-1; i++){
            for(int j = 0; j<nums.length-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    
    int[] selectionSort(int[] nums){
        for(int i = 0; i<nums.length-1; i++){
            int smallest = i;
            for(int j = i+1; j<nums.length; j++){
                if(nums[smallest]>nums[j]){
                    smallest = j;
                }
            }
            
            int temp = nums[smallest];
            nums[smallest] = nums[i];
            nums[i] = temp;
        }
        
        return nums;
    }
    
    int[] insertionSort(int[] nums){
        for(int i = 1; i<nums.length; i++){
            int curr = nums[i];
            int j = i-1;
            
            while(j>=0 && curr<nums[j]){
                nums[j+1]=nums[j];
                j--;
            }
            
            nums[j+1] = curr;
        }
        
        return nums;
    }
}