class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr : matrix){
            if(bs(arr,target)){
                return true;
            }
        }
        return false;
    }
    
    
     boolean bs(int[] arr, int targ){
         int l = 0, r = arr.length-1;
         
         while(l<r){
             int mid = l + (r-l)/2;
             
             if(arr[mid]==targ){
                 return true;
             }
             else if(arr[mid]<targ){
                 l = mid + 1;
             } else {
                 r = mid;
             }
         }
         
         return arr[l]==targ;
     }
}