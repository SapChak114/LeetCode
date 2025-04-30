class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            if ((getCount(num) & 1) == 0) {
                ans++;
            }
        }

        return ans;
    }

    int getCount(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}