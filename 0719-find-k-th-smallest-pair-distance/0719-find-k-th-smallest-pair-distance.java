class Solution {
    int[] nums;
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = Arrays.stream(nums).max().getAsInt();
        this.nums = nums;
        Arrays.sort(nums);

        while (l < r) {
            int mid = l + (r-l)/2;
            int pairs = helper(mid);

            if (pairs >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    int helper(int dist) {
        int l = 0, res = 0;

        for (int r = 0; r<nums.length; r++) {
            while (nums[r] - nums[l] > dist) {
                l++;
            }
            res += r-l;
        }

        return res;
    }
}