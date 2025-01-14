class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int i = 1; i<n; i++) {
            //if (n % i == 0) {
                String sub = s.substring(0, i).repeat(n/i);
                if (s.equals(sub)) {
                    return true;
                }
            //}
        }

        return false;
    }
}