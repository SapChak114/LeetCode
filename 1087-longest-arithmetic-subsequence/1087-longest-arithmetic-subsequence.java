class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<String, Integer> dp = new HashMap<>();

        for (int right = 0; right<n; right++) {
            for (int left = 0; left<right; left++) {
                int diff = nums[right] - nums[left];
                String leftMax = left +"_"+ diff;
                String rightMax = right +"_"+ diff;
                dp.put(rightMax, dp.getOrDefault(leftMax, 1) + 1); 
            }
        }

        return Collections.max(dp.values());
    }
}