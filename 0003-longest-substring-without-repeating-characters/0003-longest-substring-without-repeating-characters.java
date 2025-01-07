class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, n = s.length(), res = 0;

        for (int right = 0; right<n; right++) {
            char c = s.charAt(right);
            if (!charSet.contains(c)) {
                charSet.add(c);
                res = Math.max(res, right - left + 1);
            } else {
                while (charSet.contains(c)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(c);
            }
        }

        return res;
    }
}