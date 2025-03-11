class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, left = 0, sum = 0, ans = Integer.MAX_VALUE, currShort = Integer.MAX_VALUE;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int right = 0; right<arr.length; right++) {
            sum += arr[right];

            while (left < n && sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                if (left > 0 && dp[left - 1] < Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[left-1] + (right - left + 1));
                }

                currShort = Math.min(currShort, right - left + 1);
            }

            dp[right] = currShort;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}