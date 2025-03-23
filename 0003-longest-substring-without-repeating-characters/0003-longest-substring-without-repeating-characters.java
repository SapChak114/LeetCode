class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length, left = 0, len = 0;

        Map<Character, Integer> idMap = new HashMap<>();
        for (int right = 0; right<n; right++) {
            if (idMap.containsKey(ch[right])) {
                left = Math.max(left, idMap.get(ch[right]) + 1);
            }
            idMap.put(ch[right], right);

            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}