class Solution {
    public int smallestNumber(int n) {
        int x = 1;

        while (true) {
            if (x >= n) {
                return x;
            }

            x = x*2 + 1;
        }
    }
}