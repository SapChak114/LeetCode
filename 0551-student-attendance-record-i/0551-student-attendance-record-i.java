class Solution {
    public boolean checkRecord(String s) {
        int n = s.length(), A = 0, L = 0;
        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (c == 'A') {
                A++;
            }
        }

        if (A >= 2) {
            return false;
        }

        int max = 0;
        for (char c : ch) {
            if (c == 'L') {
                L++;
            } else {
                L = 0;
            }
            max = Math.max(max, L);
        }

        return max < 3;
    }
}