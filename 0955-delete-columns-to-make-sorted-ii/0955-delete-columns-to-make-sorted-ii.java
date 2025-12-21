class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int count = 0;

        String[] newStr = new String[n];

        for (int j = 0; j<m; j++) {
            for (int i = 0; i<n; i++) {
                newStr[i] += strs[i].charAt(j);
            }

            if (notLexo(newStr)) {
                for (int i = 0; i<n; i++) {
                    newStr[i] = new StringBuilder(newStr[i]).deleteCharAt(newStr[i].length()-1).toString();
                }
                count++;
            }
        }

        return count;
    }

    boolean notLexo(String[] newStr) {
        for (int i = 1; i<newStr.length; i++) {
            if (newStr[i].compareTo(newStr[i-1]) < 0) {
                return true;
            }
        }

        return false;
    }
}