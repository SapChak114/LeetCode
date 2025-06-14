class Solution {
    public int minMaxDifference(int num) {
        String numVal = String.valueOf(num);
        String minVal = numVal;
        int n = numVal.length();

        int pos = 0;
        while (pos < n-1 && numVal.charAt(pos) == '9') {
            pos++;
        }

        numVal = numVal.replace(numVal.charAt(pos), '9');
        minVal = minVal.replace(minVal.charAt(0), '0');

        return Integer.parseInt(numVal) - Integer.parseInt(minVal);
    }
}