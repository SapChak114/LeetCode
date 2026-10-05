class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), left = 0, res = 0;

        Set<Character> set = new HashSet<>();
        for (int right = 0; right<n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }

            set.add(s.charAt(right));

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}