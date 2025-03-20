class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int a = 0;
        int l = 0, r = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        while (r < n) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.addLast(r);

            if (!dq.isEmpty() && dq.peekFirst() < l) {
                dq.pollFirst();
            }

            if (r>= k-1) {
                output[a++] = nums[dq.peekFirst()];
                l++;
            }
            r++;
        }

        return output;
    }
}