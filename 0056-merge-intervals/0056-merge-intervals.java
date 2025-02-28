class Solution {
    public int[][] merge(int[][] ivs) {
        int n = ivs.length;
        Arrays.sort(ivs, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();
        int[] prev = ivs[0];

        for (int i = 1; i<n; i++) {
            int[] iv = ivs[i];

            if (iv[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], iv[1]);
            } else {
                ans.add(prev);
                prev = iv;
            }
        }
        ans.add(prev);

        return ans.toArray(new int[ans.size()][]);
    }
}