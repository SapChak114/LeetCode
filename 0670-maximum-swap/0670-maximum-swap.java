class Solution {
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }

        StringBuilder digits = new StringBuilder(Integer.toString(num));
        int n = digits.length();
        for (int i = 0; i<n; i++) {
            int maxDigitIdx = i;
            for (int j = i+1; j<n; j++) {
                if (digits.charAt(maxDigitIdx) <= digits.charAt(j)) {
                    maxDigitIdx = j;
                }
            }

            if (maxDigitIdx != i && (digits.charAt(maxDigitIdx)-'0') != (digits.charAt(i)-'0')) {
                char temp = digits.charAt(maxDigitIdx);
                digits.setCharAt(maxDigitIdx, digits.charAt(i));
                digits.setCharAt(i, temp);
                break;
            }
        }

        return Integer.valueOf(digits.toString());
    }
}