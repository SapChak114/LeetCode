class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count += 2;
            } else {
                set.add(c);
            }
        }

        return set.isEmpty() ? count : count + 1;
    }
}