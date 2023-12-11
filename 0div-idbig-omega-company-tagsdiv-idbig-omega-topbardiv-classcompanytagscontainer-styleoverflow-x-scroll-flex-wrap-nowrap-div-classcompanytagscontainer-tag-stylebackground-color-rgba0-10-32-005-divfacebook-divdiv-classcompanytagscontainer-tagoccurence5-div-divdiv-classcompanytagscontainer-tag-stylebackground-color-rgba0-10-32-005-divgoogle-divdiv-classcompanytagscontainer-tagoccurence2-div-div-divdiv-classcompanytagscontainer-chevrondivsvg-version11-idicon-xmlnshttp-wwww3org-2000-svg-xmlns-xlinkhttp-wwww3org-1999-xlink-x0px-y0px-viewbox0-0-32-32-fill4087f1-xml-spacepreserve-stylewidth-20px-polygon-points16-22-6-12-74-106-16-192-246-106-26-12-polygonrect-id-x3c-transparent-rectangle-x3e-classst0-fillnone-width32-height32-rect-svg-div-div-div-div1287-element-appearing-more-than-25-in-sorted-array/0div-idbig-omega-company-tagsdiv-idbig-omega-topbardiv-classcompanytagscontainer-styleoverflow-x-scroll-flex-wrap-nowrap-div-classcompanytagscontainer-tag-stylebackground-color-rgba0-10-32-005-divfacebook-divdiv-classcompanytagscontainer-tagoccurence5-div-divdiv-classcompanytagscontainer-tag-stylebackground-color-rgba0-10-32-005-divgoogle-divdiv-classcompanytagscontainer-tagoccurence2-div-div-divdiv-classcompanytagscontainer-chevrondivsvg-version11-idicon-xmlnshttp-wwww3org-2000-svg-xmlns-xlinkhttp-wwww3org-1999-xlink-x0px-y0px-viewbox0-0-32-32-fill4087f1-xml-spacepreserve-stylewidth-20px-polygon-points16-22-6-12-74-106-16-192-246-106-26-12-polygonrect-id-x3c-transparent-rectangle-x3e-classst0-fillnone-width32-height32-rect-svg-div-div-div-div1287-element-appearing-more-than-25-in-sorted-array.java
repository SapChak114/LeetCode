class Solution {
    public int findSpecialInteger(int[] arr) {
       int count = 1, maxCount = 0, n = arr.length, ans = 0;
        
        for (int i = 1; i < arr.length; i++) {
        count = (arr[i] == arr[i - 1]) ? count + 1 : 1;
        if (count > maxCount) {
            maxCount = count;
            ans = arr[i];
        }
    }
        if(count>maxCount){
            ans = arr[n-1];
        }
        
        return ans;
    }
}