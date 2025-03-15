class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0, r = n - k;
        while (l < r) {
            int mid = l + (r - l)/2;

            if ((x - arr[mid]) > (arr[mid + k] - x)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return Arrays.asList(Arrays.stream(Arrays.copyOfRange(arr, l, l + k))
                                 .boxed()
                                 .toArray(Integer[]::new));
    }
}