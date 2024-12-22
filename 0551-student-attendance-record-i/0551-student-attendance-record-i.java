class Solution {
    public boolean checkRecord(String s) {
        int A = 0, L = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                A++;
                if (A >= 2) {
                    return false;
                }
            }
            
            if (c == 'L') {
                L++;
                if (L >= 3) {
                    return false;
                }
            } else {
                L = 0;
            }
        }

        return true;
    }
}