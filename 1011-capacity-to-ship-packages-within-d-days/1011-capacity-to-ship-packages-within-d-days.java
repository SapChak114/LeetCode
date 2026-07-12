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

            int daysNeeded = 1, currWeight = 0;
            for (int weight : weights) {
                if (currWeight + weight > mid) {
                    daysNeeded++;
                    currWeight = 0;
                }
                currWeight += weight;
            }

            if (daysNeeded > days) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;

    }
}