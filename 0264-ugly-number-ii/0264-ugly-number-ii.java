class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        long num = 1;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i<n; i++) {
            num = pq.poll();
            for (long factor : Arrays.asList(2, 3, 5)) {
                if (!set.contains(num * factor)) {
                    set.add((num * factor));
                    pq.add((num * factor));
                }
            }
        }

        return (int) num;
    }
}