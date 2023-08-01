class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, water = 0;
        
        while(l<r){
            min = Math.min(height[r],height[l]);
            if(height[l]<height[r]){
                l++;
            } else{
                r--;
            }
            
            max = Math.max(max,min);
            water += max-min;
        }
        
        return water;
    }
}