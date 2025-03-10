class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = l + (r-l)/2;
            int hr = 0;

            for (int p : piles) {
                hr += Math.ceil((double)p / k);
            }

            if (hr <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}