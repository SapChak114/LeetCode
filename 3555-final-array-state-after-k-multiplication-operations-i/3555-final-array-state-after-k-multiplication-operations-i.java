class Pair{
    int num;
    int idx;

    public Pair(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.num != b.num) {
                return a.num - b.num; // Compare by value.
            }
            return a.idx - b.idx;   // If values are equal, compare by index.
        });

        for (int i = 0; i<nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }

        while (k-- > 0) {
            Pair p = pq.poll();
            p.num *= multiplier; 
            pq.add(p);
        }

        int[] res = new int[pq.size()];


        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            res[p.idx] = p.num; 
        }

        return res;
    }
}