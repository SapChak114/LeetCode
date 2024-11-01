class Solution {
    public String makeFancyString(String s) {
        char[] ch = s.toCharArray();
        if (ch.length < 3) {
            return new String(ch);
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i<sb.length()-1; i++) {
            if (sb.charAt(i-1) == sb.charAt(i) && sb.charAt(i) == sb.charAt(i+1)) {
                sb.deleteCharAt(i+1);
                i--;
            }
        }   

        return sb.toString();
    }
}