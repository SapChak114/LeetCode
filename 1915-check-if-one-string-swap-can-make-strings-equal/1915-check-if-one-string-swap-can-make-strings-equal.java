class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstIndexDiff = 0, secondIndexDiff = 0, numDiff = 0;

        for (int i = 0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiff++;

                if (numDiff > 2) {
                    return false;
                } else if (numDiff == 1) {
                    firstIndexDiff = i;
                } else if (numDiff == 2) {
                    secondIndexDiff = i;
                }
            }
        }

        return s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) && s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff);
    }
}