class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, ans = 0, right = 0;
        char[] ch = s.toCharArray();

        while (right < ch.length) {
            if (map.containsKey(ch[right])) {
                left = Math.max(left, map.get(ch[right]) + 1);
            }

            map.put(ch[right], right);

            ans = Math.max(ans, right - left + 1);

            right++;
        }

        return ans;
    }
}