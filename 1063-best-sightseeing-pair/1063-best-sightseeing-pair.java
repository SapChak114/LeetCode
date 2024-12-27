class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0, maxI = 0;
        int n = values.length;

        for (int i = 0; i<n; i++) {
            max = Math.max(max, maxI + values[i] - i);
            maxI = Math.max(maxI, values[i] + i);
        }

        return max;
    }
}