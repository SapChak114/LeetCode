class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 0, r = Arrays.stream(nums).max().getAsInt();

        while (l < r) {
            int mid = (l + r) >> 1;

            if (check(mid, nums) > maxOperations) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    int check(int mid, int[] nums) {
        int ops = 0;

        for (int num : nums) {
            ops += (int)(Math.ceil(((double)num/mid)) - 1d);
        }

        return ops;
    }
}
/**
[9]
maxOps = 2

[9] ops = 2
ops = 1
    9 / 2 = 4
    4 + 1 = 5
 */