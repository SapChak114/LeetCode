class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int monday = 1;
        while (n > 0) {
            for (int i = 0; i<Math.min(n, 7); i++) {
                total += monday + i;
            }
            monday++;
            n -= 7;
        }

        return total;
    }
}