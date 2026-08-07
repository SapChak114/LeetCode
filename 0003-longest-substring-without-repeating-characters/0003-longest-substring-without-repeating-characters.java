class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int size = 0;
        for (int right = 0; right<n; right++) {
            if (map.containsKey(ch[right])) {
                left = Math.max(left, map.get(ch[right]) + 1);
            }

            map.put(ch[right], right);
            size = Math.max(size, right - left + 1);
        }

        return size;
    }
}