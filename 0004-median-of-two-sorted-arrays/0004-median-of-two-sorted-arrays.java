class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if(m<n){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        
        int lo = 0, hi = n;
        
        int total = n+m+1;
        
        while(lo<=hi){
            int midX = lo + (hi-lo)/2;
            int midY = total/2 - midX;
            
            int minX = midX<=0?Integer.MIN_VALUE:nums1[midX-1];
            int maxX = midX>=n?Integer.MAX_VALUE:nums1[midX];
            
            int minY = midY<=0?Integer.MIN_VALUE:nums2[midY-1];
            int maxY = midY>=m?Integer.MAX_VALUE:nums2[midY];
            
            if(minX<=maxY && minY<=maxX){
                if((m+n)%2==0){
                    return ((double)Math.max(minX,minY) + Math.min(maxX,maxY))/2.0;
                } else{
                    return (double)Math.max(minX,minY);
                }
            }
            else if(minY>maxX){
                lo = midX + 1;
            } else{
                hi = midX - 1;
            }
        }
        
        return 0;
        
    }
}
