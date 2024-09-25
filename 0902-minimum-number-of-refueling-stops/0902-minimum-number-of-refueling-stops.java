class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int refill = 0, i = 0, distance = startFuel;

        while (distance < target) {
            while (i < n && distance >= stations[i][0]) {
                pq.add(stations[i]);
                i++;
            }

            if (pq.isEmpty()) return -1;

            distance += pq.poll()[1];
            refill++;
        }

        return refill;
    }
}