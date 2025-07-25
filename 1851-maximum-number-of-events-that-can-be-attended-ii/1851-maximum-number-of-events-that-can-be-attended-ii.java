class Solution {
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;

        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, k, events);
    }

    int dfs(int currIndex, int count, int[][] events) {
        if (count == 0 || currIndex == events.length) {
            return 0;
        }

        if (dp[count][currIndex] != -1) {
            return dp[count][currIndex];
        }

        int nextIndex = bs(events, events[currIndex][1]);
        dp[count][currIndex] = Math.max(dfs(currIndex + 1, count, events), events[currIndex][2] + dfs(nextIndex, count - 1, events));
        return dp[count][currIndex];
    }

    public int bs(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}