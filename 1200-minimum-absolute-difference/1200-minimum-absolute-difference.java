class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i<n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }

        for (int i = 1; i<n; i++) {
            int diff = arr[i] - arr[i-1];

            if (diff == minDiff) {
                ans.add(List.of(arr[i-1], arr[i]));
            }
        }

        return ans;
    }
}