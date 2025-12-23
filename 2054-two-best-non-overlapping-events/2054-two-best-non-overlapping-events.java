class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int m = events[0].length;


        List<int[]> time = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            int start = events[i][0];
            int end = events[i][1];
            int val = events[i][2];

            time.add(new int[]{start, 1, val});
            time.add(new int[]{end + 1, 0, val});
        }

        time.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int maxSum = 0, ans = 0;
        for (int i = 0; i<time.size(); i++) {
            if (time.get(i)[1] == 1) {
                ans = Math.max(ans, time.get(i)[2] + maxSum);
            } else {
                maxSum = Math.max(maxSum, time.get(i)[2]);
            }
        }

        return ans;
    }
}