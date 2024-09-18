class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);
            if (!map.containsKey(st)) {
                map.put(st, new ArrayList<>());
            }

            map.get(st).add(s);
        }

        return new ArrayList<>(map.values());
    }
}