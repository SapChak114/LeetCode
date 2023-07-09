class Solution {
    public int trap(int[] ar) {
        
        int n = ar.length, l = 0, r = n-1, maxOfMin = Integer.MIN_VALUE, water = 0;
        
        while(l<=r){            
            int min = 0;
            if(ar[l]<ar[r]) min = ar[l++];
            else min = ar[r--];
            
            maxOfMin = Math.max(maxOfMin,min);
            water += maxOfMin - min;
        }
        
        return water;
    }
}