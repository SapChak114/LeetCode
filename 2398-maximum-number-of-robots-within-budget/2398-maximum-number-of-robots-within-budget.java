class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length, l = 0, ans = 0;
        long sum = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for (int r = 0; r<n; r++) {
            sum += runningCosts[r];

            while (!dq.isEmpty() && chargeTimes[dq.peekLast()] <= chargeTimes[r]) {
                dq.pollLast();
            }
            dq.addLast(r);

            while (!dq.isEmpty() && l <= r && (chargeTimes[dq.peekFirst()] + (r-l+1) * sum) > budget) {
                sum -= runningCosts[l++];

                if (!dq.isEmpty() && dq.peekFirst() < l) {
                    dq.pollFirst();
                }
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}