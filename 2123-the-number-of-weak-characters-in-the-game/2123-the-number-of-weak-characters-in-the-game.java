class Solution {
    public int numberOfWeakCharacters(int[][] prop) {
        Arrays.sort(prop, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        int max = 0, ans = 0;

        for (int[] val : prop) {
            if (val[1] < max) {
                ans++;
            }

            max = Math.max(max, val[1]);
        }

        return ans;
    }
}