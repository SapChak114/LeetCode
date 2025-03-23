class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }

            if (i == n || j == n) {
                break;
            }

            if (start.charAt(i) != end.charAt(j) || (start.charAt(i) == 'L' && i<j) || (start.charAt(i) == 'R' && i>j)) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}