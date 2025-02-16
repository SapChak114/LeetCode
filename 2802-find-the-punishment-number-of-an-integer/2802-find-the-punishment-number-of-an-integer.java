class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;

        for (int i = 1; i<=n; i++) {
            int sq = i * i;
            if (canPartition(sq, i)) {
                sum += sq;
            }
        }

        return sum;
    }

    boolean canPartition(int sq, int num) {
        if (num < 0 || sq < num) {
            return false;
        }

        if (sq == num) {
            return true;
        }

        return (canPartition(sq / 10, num - (sq % 10)) ||
                canPartition(sq / 100, num - (sq % 100)) ||
                canPartition(sq / 1000, num - (sq % 1000)));
    }
}