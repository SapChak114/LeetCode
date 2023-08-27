class Solution {
    public long minimumPossibleSum(int n, int target) {
        int x = target / 2;
        long ans = 0;
        for (int i = 1; i <= x; i++) {
            ans += i;
            n--;
            if (n == 0) {
                break;
            }
        }
        int z = target;
        while (n > 0) {
            ans += z;
            z++;
            n--;
        }
        return ans;
    }
}