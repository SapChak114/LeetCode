class Solution {
    public int trap(int[] ar) {
        
        int n = ar.length, l = 0, r = n-1, maxOfMin = Integer.MIN_VALUE, water = 0;
        
        while(l<=r){            
            if(ar[l]<ar[r]){
                int min = ar[l++];
                maxOfMin = Math.max(maxOfMin,min);
                water += maxOfMin - min;
            } else{
                int min = ar[r--];
                maxOfMin = Math.max(maxOfMin,min);
                water += maxOfMin - min;
            }
        }
        
        return water;
    }
}