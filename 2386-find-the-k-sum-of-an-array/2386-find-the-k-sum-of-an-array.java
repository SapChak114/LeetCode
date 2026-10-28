class Pair{
    long sum;
    int idx;

    public Pair(long sum, int idx) {
        this.sum = sum;
        this.idx = idx;
    }
}
class Solution {
    public long kSum(int[] nums, int k) {
        int n = nums.length;

        long maxSum = 0;

        for (int i = 0; i<n; i++) {
            if (nums[i] > 0) {
                maxSum += nums[i];
            } else {
                nums[i] = Math.abs(nums[i]);
            }
        }

        if (k == 1) {
            return maxSum;
        }

        Arrays.sort(nums);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum == b.sum ? Integer.compare(a.idx, b.idx) : Long.compare(a.sum, b.sum));

        pq.add(new Pair(nums[0], 0));

        long kSum = 0;
        while (k-- > 1 && !pq.isEmpty()) {
            Pair p = pq.poll();
            long sum = p.sum;
            int idx = p.idx;

            if (idx+1 < nums.length) {
                pq.add(new Pair(sum + nums[idx + 1], idx + 1));
                pq.add(new Pair(sum - nums[idx] + nums[idx + 1], idx + 1));
            }
            kSum = sum;
        }

        return maxSum - kSum;
    }
}
/**
[2,2,3,2]


 */