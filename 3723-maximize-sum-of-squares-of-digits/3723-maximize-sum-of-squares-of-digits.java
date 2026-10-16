class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int numOfNines = sum / 9;
        int rem = sum % 9;

        for (int i = 0; i<numOfNines; i++) {
            sb.append('9');
        }

        if (rem > 0) {
            sb.append((char)('0' + rem));
        }

        int zeros = num - sb.length();
        for (int i = 0; i<zeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}