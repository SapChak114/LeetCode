class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = 0;
                    fruits[i] = 0;
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i<n; i++) {
            if (baskets[i] != 0) {
                ans++;
            }
        }

        return ans;
    }
}