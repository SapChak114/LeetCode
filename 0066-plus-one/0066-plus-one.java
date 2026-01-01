class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, carr = 1;
        for (int i = n-1; i>=0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] ans = new int[n + 1];
        ans[0] = carr;
        return ans;
    }
}