class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        long one = 0, zero = 0, oneZero = 0, zeroOne = 0, ways = 0;

        for (int i = 0; i<n; i++) {
            if (s.charAt(i) == '0') {
                zero++;
                zeroOne += one;
                ways += oneZero;
            } else {
                one++;
                oneZero += zero;
                ways += zeroOne;
            }
        }

        return ways;
    }
}