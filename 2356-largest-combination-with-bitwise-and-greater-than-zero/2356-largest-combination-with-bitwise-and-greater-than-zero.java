class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[24];

        for (int i = 0; i<24; i++) {
            for (int candidate : candidates) {
                if ((candidate & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        return Arrays.stream(bitCount).max().getAsInt();
    }
}