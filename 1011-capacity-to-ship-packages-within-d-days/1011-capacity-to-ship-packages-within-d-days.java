class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = -1, high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = (low + high) / 2;

            if (check(days, weights, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    boolean check(int days, int[] weights, int mid) {
        int daysNeeded = 1, currWeight = 0;
        for (int weight : weights) {
            if (currWeight + weight > mid) {
                daysNeeded++;
                currWeight = 0;

                if (daysNeeded > days) {
                    return false;
                }
            }
            currWeight += weight;
        }

        return true;
    }
}