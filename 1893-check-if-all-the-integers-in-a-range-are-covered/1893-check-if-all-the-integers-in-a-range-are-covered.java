class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] line = new int[52];
        int n = ranges.length;

        for (int[] range : ranges) {
            line[range[0]]++;
            line[range[1] + 1]--;
        }

        int overlap = 0;
        for (int i = 1; i<=right; i++) {
            overlap += line[i];

            if (i >= left && overlap == 0) {
                return false;
            }
        }

        return true;
    }
}