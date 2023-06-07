class Solution {
    public int minFlips(int a, int b, int c) {
        int total_count = 0;

        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int a_val = (mask & a) != 0 ? 1 : 0;
            int b_val = (mask & b) != 0 ? 1 : 0;
            int c_val = (mask & c) != 0 ? 1 : 0;

            if (c_val == 0) {
                if (b_val == 1 && a_val == 1) {
                    total_count += 2;
                } else if (b_val == 1 || a_val == 1) {
                    total_count += 1;
                }
            } else if (c_val == 1 && b_val == 0 && a_val == 0) {
                total_count += 1;
            }
        }

        return total_count;
    }
}