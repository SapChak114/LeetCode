class Solution {
    List<Integer> robot;
    int[][] factory;
    Long[][] dp;
    long max = (long)1e12 + 8;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> a[0] - b[0]);
        this.robot = robot;
        this.factory = factory;
        this.dp = new Long[robot.size()][factory.length];

        return dfs(robot.size()-1, factory.length-1);
    }

    long dfs(int roboIdx, int facIdx) {
        if (roboIdx < 0) {
            return 0;
        }
        if (facIdx < 0) {
            return max;
        }
        if (dp[roboIdx][facIdx] != null) {
            return dp[roboIdx][facIdx];
        }

        long dont = dfs(roboIdx, facIdx - 1);
        long take = dont;
        long dist = 0;
        
        for (int i = 0; i<factory[facIdx][1] && (roboIdx - i) >= 0; i++) {
            dist += Math.abs(robot.get(roboIdx-i) - factory[facIdx][0]);
            take = Math.min(take, dist + dfs(roboIdx - i - 1, facIdx - 1));
        }

        return dp[roboIdx][facIdx] = take;
    }
}