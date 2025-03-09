class Solution {
    public int minimumRecolors(String blocks, int k) {
        int numWhites = 0;

        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                numWhites++;
            }
        }

        int numRecolors = numWhites;

        // Sliding window
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                numWhites--;
            }
            if (blocks.charAt(i) == 'W') {
                numWhites++;
            }

            numRecolors = Math.min(numRecolors, numWhites);
        }

        return numRecolors;
    }
}
