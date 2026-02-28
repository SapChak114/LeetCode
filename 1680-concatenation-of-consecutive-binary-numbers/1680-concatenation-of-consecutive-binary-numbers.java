class Solution {
    int mod = (int)1e9 + 7;
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        long res = 0;
        for (int i = 1; i<=n; i++) {
            int blen = Integer.toBinaryString(i).length();

            res = (((res << blen) | i) % mod);
        }

        return (int) (res);
    }
}