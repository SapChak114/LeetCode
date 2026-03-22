class Solution {
    int M = (int)1e9 + 7;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] line = new int[n];

        for (int[] request : requests) {
            int start = request[0];
            int end = request[1];

            line[start] += 1;

            if (end + 1 < n) {
                line[end + 1] -= 1;
            }
        }

        for (int i = 1; i<n; i++) {
            line[i] += line[i-1];
        }

        Arrays.sort(line);
        Arrays.sort(nums);

        long res = 0;
        for (int i = n-1; i>=0; i--) {
            res = (res + ((long)line[i] * nums[i]) % M) % M;
        }

        return (int)res;
    }
}