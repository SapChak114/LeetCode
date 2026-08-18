class Solution {
    int[][] jobs;
    Integer[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        this.dp = new Integer[n];
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        this.jobs = jobs;

        return dfs(0);
    }

    int dfs(int idx) {
        if (idx == jobs.length) {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        int res = dfs(idx + 1);

        int j = idx + 1;
        while (j < jobs.length) {
            if (jobs[idx][1] <= jobs[j][0]) {
                break;
            }
            j++;
        }

        res = Math.max(res, jobs[idx][2] + dfs(j));

        return dp[idx] = res;
    }
}