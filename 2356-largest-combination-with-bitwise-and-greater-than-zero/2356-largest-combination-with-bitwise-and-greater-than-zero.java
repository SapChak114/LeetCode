class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[24];
        int res = 0;

        for (int i = 0; i<24; i++) {
            int setBit = 0;
            for (int candidate : candidates) {
                if ((candidate & (1 << i)) != 0) {
                    setBit++;
                }
            }

            res = Math.max(res, setBit);
        }

        return res;
    }
}