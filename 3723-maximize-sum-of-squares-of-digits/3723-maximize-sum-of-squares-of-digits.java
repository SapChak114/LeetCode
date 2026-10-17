class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        int noOfNines = sum / 9;
        int rem = sum % 9;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<noOfNines; i++) {
            sb.append('9');
        }

        if (rem > 0) {
            sb.append((char) ('0' + rem));
        }

        int zeros = num - sb.length();

        for (int i = 0; i<zeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}