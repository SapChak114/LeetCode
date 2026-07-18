class Solution {
    public char findTheDifference(String s, String t) {
        char[] st = s.toCharArray();
        char[] ts = t.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : st) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ts) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return c;
            }
        }

        return '#';
    }
}