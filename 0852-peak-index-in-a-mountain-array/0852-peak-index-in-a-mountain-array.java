class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-1;

        while (l < r) {
            int mid = l + (r-l)/2;
            //System.out.println(mid+" "+l+" "+r);

            if (arr[mid] < arr[mid+1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}