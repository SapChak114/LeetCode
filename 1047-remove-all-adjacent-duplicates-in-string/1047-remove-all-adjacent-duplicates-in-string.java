class Solution {
    public String removeDuplicates(String s) {
        int n = s.length(), i = 0;
        char[] ch = s.toCharArray();
        
        for (int j = 0; j<n; j++, i++) {
            ch[i] = ch[j];
            if (i > 0 && ch[i - 1] == ch[i]) {
                i -= 2;
            }
        }

        return new String(ch, 0, i);
    }
}