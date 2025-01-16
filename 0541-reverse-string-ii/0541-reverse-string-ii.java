class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();

        for (int start = 0; start<n; start += 2*k) {
            int i = start, j = Math.min(start + k - 1, n-1);

            while (i<j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }

        return new String(ch);
    }
}