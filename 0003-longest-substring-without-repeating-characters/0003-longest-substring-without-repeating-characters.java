class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int left = 0, len = 0;

        Set<Character> map = new HashSet<>();
        for (int right = 0; right<n; right++) {
            while (map.contains(s.charAt(right))) {
                 map.remove(s.charAt(left));
                 left++;
            }

            map.add(s.charAt(right));

            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}