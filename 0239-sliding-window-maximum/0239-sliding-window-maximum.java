class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 0;

        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i<n; i++) {
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.add(i);

            if (i >= k - 1) {
                res[idx++] = nums[dq.peek()];
            }
        }

        return res;
    }
}