class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        double val = Math.log10(n) / Math.log10(3);

        return val == (int)val;
    }
}