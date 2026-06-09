class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i<n*2; i++) {
            int j = i % n;

            while (!st.isEmpty() && nums[st.peek()] < nums[j]) {
                res[st.pop()] = nums[j];
            }

            if (i < n) {
                st.push(i);
            }
        }

        return res;
    }
}