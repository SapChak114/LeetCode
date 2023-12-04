class Solution {
    public String largestGoodInteger(String num) {
        char[] digits = num.toCharArray();
        StringBuilder ansBuilder = new StringBuilder();
        int consecutiveCount = 1;

        for (int i = 1; i < digits.length; i++) {
            consecutiveCount = (digits[i - 1] == digits[i]) ? ++consecutiveCount : 1;

            if (consecutiveCount == 3 && (ansBuilder.length() == 0 || Integer.parseInt(String.valueOf(digits[i])) > Integer.parseInt(ansBuilder.toString()))) {
                ansBuilder.setLength(0);  // Clear previous content
                ansBuilder.append(digits[i]);
            }
        }

        return ansBuilder.toString() + ansBuilder.toString() + ansBuilder.toString();
    }
}
