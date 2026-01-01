class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, carr = 1;
        for (int i = n-1; i>=0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                carr = 0;
                break;
            }
        }

        int[] ans = new int[carr == 0 ? n : n + 1];

        for (int i = carr; i<n; i++) {
            ans[i] = digits[i];
        }

        if (carr == 1) {
            ans[0] = 1;
        }

        return ans;
    }
}