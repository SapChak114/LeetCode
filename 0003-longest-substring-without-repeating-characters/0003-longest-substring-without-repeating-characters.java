class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] ch = s.toCharArray();

        int left = 0, ans = 0;
        for (int right = 0; right<ch.length; right++) {
            if (map.containsKey(ch[right])) {
                left = Math.max(left, map.get(ch[right]) + 1);
            }
            map.put(ch[right], right);

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}