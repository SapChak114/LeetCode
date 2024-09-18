import java.util.Arrays;

class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        
        // If the sum is odd, it cannot be partitioned into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        // Target sum is half of the total sum
        int target = sum / 2;
        
        // Create a DP table initialized to -1 (not computed)
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return canPartitionHelper(target, nums, n - 1, dp);
    }

    private boolean canPartitionHelper(int k, int[] arr, int i, int[][] dp) {
        // Base case: If no more elements to pick and k is not 0, return false
        if (i < 0 && k != 0) {
            return false;
        }
        
        // Base case: If only one element left, check if it equals k
        if (i == 0) {
            return arr[i] == k;
        }

        // Check if the result is already computed
        if (dp[i][k] != -1) {
            return dp[i][k] == 1;
        }

        // Recursively check if we can take the current element or not
        boolean take = false;
        if (arr[i] <= k) {
            take = canPartitionHelper(k - arr[i], arr, i - 1, dp);
        }
        boolean notTake = canPartitionHelper(k, arr, i - 1, dp);

        // Store the result in the DP table
        dp[i][k] = (take || notTake) ? 1 : 0;
        
        return dp[i][k] == 1;
    }
}
