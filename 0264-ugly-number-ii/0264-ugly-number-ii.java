class Solution {
    public int nthUglyNumber(int n) {
        int two = 2, three = 3, five = 5;
        int i2 = 0, i3 = 0, i5 = 0;

        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i<n; i++) {
            int min = Math.min(two, Math.min(three, five));
            res[i] = min;

            if (min == two) {
                i2++;
                two = res[i2] * 2;
            }

            if (min == three) {
                i3++;
                three = res[i3] * 3;
            }

            if (min == five) {
                i5++;
                five = res[i5] * 5;
            }
        }

        return res[n-1];
    }
}