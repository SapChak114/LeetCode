class Solution {
    public int findSpecialInteger(int[] arr) {
       int count = 1, maxCount = 0, n = arr.length, ans = 0;
        
        for(int i = 1; i<n; i++){
            if(arr[i]==arr[i-1]){
                count++;
                if(count>maxCount){
                    ans = arr[i];
                    maxCount=count;
                }
                
            } else count = 1;
        }
        if(count>maxCount){
            ans = arr[n-1];
        }
        
        return ans;
    }
}