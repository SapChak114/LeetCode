class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 1; i<n; i++) {
            if (ratings[i-1] < ratings[i]) {
                arr[i] = arr[i-1] + 1; 
            }
        }

        for (int i = n-2; i>=0; i--) {
            if (ratings[i+1] < ratings[i]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        return (int) Arrays.stream(arr).sum();
    }
}