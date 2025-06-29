class Solution {
    public int integerReplacement(int n) {
        return ops(n);
    }

    int ops(long n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return 1 + ops(n/2);
        } else {
            return 1 + Math.min(ops(n + 1), ops(n - 1));
        }
    }
}