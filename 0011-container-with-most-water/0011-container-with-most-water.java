class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length-1;
        int res = 0;
        while(l<r){
            int area = (r-l) * Math.min(h[r],h[l]);
            res = Math.max(res,area);
            
            if(h[l]<h[r]){
                l++;
            } else{
                r--;
            }
        }
        
        return res;
    }
}