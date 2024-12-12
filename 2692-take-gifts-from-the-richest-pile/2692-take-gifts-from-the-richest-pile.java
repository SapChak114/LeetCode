class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int gt : gifts) {
            pq.add(gt);
        }

        while (k-- > 0) {
            int num = pq.poll();
            pq.add((int)Math.floor(Math.sqrt(num)));
        }

        long sum = 0;

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}