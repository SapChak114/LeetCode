class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int ans = arr[0];
        int noDelete = arr[0];
        int oneDelete = arr[0];

        for (int i = 1; i < n; ++i) {
            oneDelete = Math.max(oneDelete + arr[i], noDelete); // delete current or continue deleted case
            noDelete = Math.max(noDelete + arr[i], arr[i]);     // standard Kadane
            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans;
    }
}
