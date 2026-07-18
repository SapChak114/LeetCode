class Solution {
    public char findTheDifference(String s, String t) {
        char[] st = s.toCharArray();
        char[] ts = t.toCharArray();

        char ch = 0;
        for (char c : st) {
            ch ^= c;
        }

        for (char c : ts) {
            ch ^= c;
        }

        return ch;
    }
}