class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;

        int n = s.length(), left = 0;
        for (int right = 0; right<n; right++) {
            char c = s.charAt(right);

            while(set.contains(c)) {
                set.remove(s.charAt(left++));
            }

            set.add(c);

            ans = Math.max(ans, right - left + 1);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}