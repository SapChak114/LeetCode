class Solution {
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);

        for (int nodes = 2; nodes<=n; nodes++) {
            int total = 0;
            for (int root = 1; root<=nodes; root++) {
                int left = root - 1;
                int right = nodes - root;
                total += arr[left] * arr[right];
            }
            arr[nodes] = total;
        }

        return arr[n];
    }
}