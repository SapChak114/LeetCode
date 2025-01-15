class Solution {
    public boolean checkRecord(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int countA = 0, countL = 0;

        int n = s.length();

        countA += s.charAt(0) == 'A' ? 1 : 0;
        for (int i = 1; i<n-1; i++) {
            if (s.charAt(i-1) == 'L' && s.charAt(i) == 'L' && s.charAt(i+1) == 'L') {
                return false;
            } else if (s.charAt(i) == 'A') {
                countA++;
            }
        }

        if (n > 1) {
            countA += s.charAt(n-1) == 'A' ? 1 : 0;
        }

        return countA < 2;
    }
}