class Solution {
    public int firstUniqChar(String s) {
        char[] ch = s.toCharArray();

        int n = ch.length;
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : ch) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i<ch.length; i++) {
            if (freq.containsKey(ch[i]) && freq.get(ch[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}