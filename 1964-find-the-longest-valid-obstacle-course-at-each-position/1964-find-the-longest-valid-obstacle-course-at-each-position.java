class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] ob) {
        int[] lis = new int[ob.length];
        Arrays.fill(lis,Integer.MAX_VALUE);
        int[] ans = new int[ob.length];
        
        int index = 0;
        for(int i = 0; i<ob.length; i++){
            int idx = binarySearch(lis,ob[i]);
            lis[idx] = ob[i];
            ans[index++] = idx + 1;
        }
        
        return ans;
    }
    
    int binarySearch(int[] lis, int targ){
        int low = 0;
        int high = lis.length-1;
        while(low<=high){
            int mid = (low+high) >> 1;
            
            if(lis[mid]<=targ){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        
        return low;
    }
}