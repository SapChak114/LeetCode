class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;

        for (int num : nums) {
            if (num == 0) {
                red++;
            } else if (num == 1) {
                white++;
            } else {
                blue++;
            }
        }

        fill(0, red, nums, 0);
        fill(red, red+white, nums, 1);
        fill(red+white, red+white+blue, nums, 2);
        
    }

    void fill(int s, int e, int[] nums, int val) {
        for (int i = s; i<e; i++) {
            nums[i] = val;
        }
    }
}