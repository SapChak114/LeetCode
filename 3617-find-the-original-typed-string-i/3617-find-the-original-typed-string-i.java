class Solution {
    public int possibleStringCount(String word) {
        char[] ch = word.toCharArray();
        int count = 1;

        for (int i = 1; i<ch.length; i++) {
            if (ch[i] == ch[i-1]) {
                count++;
            }
        }

        return count;
    }
}