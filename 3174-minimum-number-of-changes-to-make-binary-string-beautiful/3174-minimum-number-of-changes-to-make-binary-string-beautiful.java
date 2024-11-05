class Solution {
    public int minChanges(String s) {
        char currentChar = s.charAt(0);
        int minChange = 0, charCount = 0;

        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                charCount++;
                continue;
            }

            if (charCount % 2 == 0) {
                charCount = 1;
            } else {
                charCount = 0;
                minChange++;
            }
            currentChar = s.charAt(i);
        }

        return minChange;
    }
}