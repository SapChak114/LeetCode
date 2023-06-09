class Solution {
    public char nextGreatestLetter(char[] a, char x) {
        if(a[a.length-1]<=x) return a[0];
        int lo = 0;
        int hi = a.length-1;
        while(lo<hi){
            int mid = (lo + hi)/2;
            if(x<a[mid]){
                hi=mid;
            } else{
                lo = mid + 1;
            }
        }
        
        return a[lo];
    }
}