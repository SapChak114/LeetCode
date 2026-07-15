class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int h = Arrays.stream(bloomDay).max().getAsInt();
        int l = 0, ans = -1;

        while (l <= h) {
            int mid = l + (h-l) / 2;

            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    boolean possible(int[] bloom, int day, int m, int k) {
        int count = 0, bouquets = 0;

        for (int i = 0; i<bloom.length; i++) {
            if (bloom[i] <= day) {
                count++;
            } else {
                bouquets += (count/k);
                count = 0;
            }
        }

        bouquets += (count/k);

        return bouquets >= m;
    }
}