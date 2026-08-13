class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int left = 0, len = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right<n; right++) {
            while (map.containsKey(s.charAt(right))) {
                 map.remove(s.charAt(left));
                 left++;
            }

            map.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}