class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int prev = pairs[0][1], n = pairs.length, count = 1;

        for (int i = 1; i<n; i++) {
            int[] pair = pairs[i];
            int start = pair[0];
            int end = pair[1];

            if (prev < start) {
                count++;
                prev = end;
            }
        }

        return count;
    }
}