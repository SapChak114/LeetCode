class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[] digitSum = new int[n];
        for (int i = 0; i<n; i++) {
            int x = nums[i];
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            digitSum[i] = sum;
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i<n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            if (digitSum[a] != digitSum[b]) {
                return Integer.compare(digitSum[a], digitSum[b]);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        int[] targetPos = new int[n];
        for (int i = 0; i<n; i++) {
            targetPos[indices[i]] = i;
        }

        boolean[] vis = new boolean[n];
        int cycles = 0;
        for (int i = 0; i<n; i++) {
            if (!vis[i]) {
                cycles++;
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    j = targetPos[j];
                }
            }
        }

        return n - cycles;
    }
}