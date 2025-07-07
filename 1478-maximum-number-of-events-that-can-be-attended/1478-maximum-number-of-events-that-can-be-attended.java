class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int n = events.length;
        int pos = 0, time = 1, attended = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (pos < n || !minHeap.isEmpty()) {

            if (minHeap.isEmpty()) {
                time = Math.max(time, events[pos][0]);
            }
            
            while (pos < n && events[pos][0] == time) {
                minHeap.add(events[pos][1]);
                pos++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < time) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }

            time++;
        }

        return attended;
    }
}