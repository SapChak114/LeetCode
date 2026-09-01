class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        int n = points.length, ans = Integer.MIN_VALUE;

        for (int i = 0; i<n; i++) {
            while (!pq.isEmpty() && points[i][0] - pq.peek()[1] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans = Math.max(ans, points[i][0] + points[i][1] + pq.peek()[0]);
            }
            pq.add(new int[]{points[i][1] - points[i][0], points[i][0]});
        }

        return ans;
    }
}