class Solution {
    public int minimumRecolors(String blocks, int k) {
        Queue<Character> bQ = new LinkedList<>();
        int numWhites = 0;

        for (int i = 0; i<k; i++) {
            char currChar = blocks.charAt(i);
            if (currChar == 'W') {
                numWhites++;
            }
            bQ.add(currChar);
        }

        int numRecolors = numWhites;

        for (int i = k; i< blocks.length(); i++) {
            if (bQ.poll() == 'W') {
                numWhites--;
            }

            char currChar = blocks.charAt(i);
            if (currChar == 'W') {
                numWhites++;
            }
            bQ.add(currChar);

            numRecolors = Math.min(numRecolors, numWhites);
        }

        return numRecolors;
    }
}