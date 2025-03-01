class Solution {
    public double myPow(double x, long n) {
        double res = helper(x, Math.abs(n));
        if (n >= 0) {
            return res;
        } else {
            return 1/res;
        }
    }

    double helper(double x, long n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        double res = helper(x*x, n/2);

        if (n % 2 == 1) {
            return x * res;
        } else {
            return res;
        }
    }
}