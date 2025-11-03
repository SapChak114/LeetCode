class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;

        int res = 0;
        for (int i = 0; i<n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums, i, 1)) {
                    res++;
                }

                if (isValid(nums, i, -1)) {
                    res++;
                }
            }
        }

        return res;
    }


    boolean isValid(int[] nums, int start, int dir) {
        int n = nums.length;

        int[] clone = nums.clone();
    
        while (start >= 0 && start < n) {
            if (clone[start] == 0) {
                start += dir;
            } else {
                clone[start] -= 1;
                dir = -dir;
                start += dir;
            }
        }

        for (int num : clone) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}