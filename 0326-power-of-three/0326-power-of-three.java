class Solution {
    public boolean isPowerOfThree(int n) {
        int val = 1;

        while (val <= n) {
            if (val == n) {
                return true;
            }
            if (val > Integer.MAX_VALUE / 2) {
                break;
            }
            val *= 3;
        }

        return false;
    }
}