class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int k = 0; k<numRows; k++) {
            sbs[k] = new StringBuilder();
        }

        int i = 0, n = s.length();

        char[] arr = s.toCharArray();

        while (i < n) {
            for (int j = 0; j<numRows && i < n; j++) {
                sbs[j].append(""+arr[i++]);
            }

            for (int j = numRows-2; j>0 && i < n; j--) {
                sbs[j].append(""+arr[i++]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (i = 0; i < numRows; i++) {
            sb.append(sbs[i].toString());
        }

        return sb.toString();
    }
}