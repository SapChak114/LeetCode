class Solution {
    public int maxScore(int[] c, int k) {
        int n = c.length;
        int total = 0;

        for (int i = 0; i<n; i++) {
            total += c[i];
        }

        if (k == n) {
            return total;
        }

        int win = n-k;
        int sum = 0;
        for (int i = 0; i<win; i++) {
            sum += c[i];
        }

        int min = sum;
        for (int i = win; i<n; i++) {
            sum += c[i] - c[i-win];
            min = Math.min(min, sum);
        }

        return total - min;
    }
}