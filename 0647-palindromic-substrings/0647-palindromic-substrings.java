class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = i; j<n; j++) {
                String str = s.substring(i, j+1);
                if (isPallin(str)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean isPallin(String str) {
        char[] ch = str.toCharArray();

        int n = ch.length;

        int i = 0, j = n - 1;

        while (i <= j) {
            if (ch[i] != ch[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}