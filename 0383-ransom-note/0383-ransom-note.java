class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        for (char c : magazine.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        for (Map.Entry<Character, Integer> e : map1.entrySet()) {
            if (!map2.containsKey(e.getKey())) {
                return false;
            }
            if (map2.containsKey(e.getKey()) && map2.get(e.getKey()) < e.getValue()) {
                return false;
            }
        }

        return true;
    }
}