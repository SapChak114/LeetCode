class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int k = l + (r - l)/2;
            int hr = 0;

            for (int p : piles) {
                hr += Math.ceil((double) p / k);
            }

            if (hr > h) {
                l = k + 1;
            } else {
                r = k;
            }
        }

        return l;
    }
}