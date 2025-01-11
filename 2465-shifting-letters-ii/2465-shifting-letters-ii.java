class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] sums = new int[n+1];

        for (int[] shift : shifts) {
            int delta = shift[2] == 0 ? -1 : 1;
            int start = shift[0];
            int end = shift[1] + 1;

            sums[start] += delta;
            sums[end] += -delta;
        }

        for (int i = 1; i<sums.length; i++) {
            sums[i] += sums[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            int ascii = s.charAt(i) - 'a';
            ascii = (ascii + sums[i]) % 26;

            if (ascii < 0) {
                ascii += 26;
            }

            sb.append(""+(char)(ascii + 'a'));
        }

        return sb.toString();
    }
}