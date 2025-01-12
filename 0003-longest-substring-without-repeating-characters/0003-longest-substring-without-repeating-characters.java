class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        int left = 0, n = ch.length, res = 0;

        for (int right = 0; right<n; right++) {
            if (!set.contains(ch[right])) {
                res = Math.max(res, right - left + 1);
            } else {
                while (set.contains(ch[right])) {
                    set.remove(ch[left]);
                    left++;
                }
            }
            set.add(ch[right]);
        }

        return res;
    }
}