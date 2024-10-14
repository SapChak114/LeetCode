class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        while (k-- > 0) {
            int val = pq.poll();
            ans += val;
            pq.add((int)Math.ceil(val / 3.0));
        }

        return ans;
    }
}