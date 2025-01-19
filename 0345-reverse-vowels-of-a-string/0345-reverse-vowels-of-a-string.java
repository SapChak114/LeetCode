class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0, j = n-1;

        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');

        StringBuilder sb = new StringBuilder(s);
        while (i < j) {
            while (i<sb.length() && !set.contains(sb.charAt(i))) {
                i++;
            }
            while (j>=0 && !set.contains(sb.charAt(j))) {
                j--;
            }

            if (i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
        }

        return sb.toString();
    }
}