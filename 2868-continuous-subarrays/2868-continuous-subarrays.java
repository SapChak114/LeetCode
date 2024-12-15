class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0, right = 0, currMin = Integer.MAX_VALUE, currMax = Integer.MIN_VALUE;
        long win = 0, total = 0;
        
        for (right = 0; right < nums.length; right++) {
            currMin = Math.min(currMin, nums[right]);
            currMax = Math.max(currMax, nums[right]);

            if (currMax - currMin > 2) {
                win = right - left;
                total += ((win * (win + 1))/2);

                left = right;
                currMin = currMax = nums[right];

                while (Math.abs(nums[left-1] - nums[right]) <= 2) {
                    left--;
                    currMin = Math.min(currMin, nums[left]);
                    currMax = Math.max(currMax, nums[left]);
                }

                if (left < right) {
                    win = right - left;
                    total -= ((win * (win + 1))/2);
                }
            }
        }

        win = right - left;
        total += ((win * (win + 1))/2);

        return total;
    }
}