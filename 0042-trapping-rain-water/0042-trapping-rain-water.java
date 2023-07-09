class Solution {
    public int trap(int[] ar) {
        
        int n = ar.length, l = 0, r = n-1, maxOfMin = Integer.MIN_VALUE, water = 0;
        
        while(l<=r){            
            int min = Math.min(ar[l],ar[r]);
            if(ar[l]<ar[r]) l++;
            else r--;
            
            maxOfMin = Math.max(maxOfMin,min);
            water += maxOfMin - min;
        }
        
        return water;
    }
}