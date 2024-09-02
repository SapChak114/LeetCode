class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sortedWord = new String(ch);

            if (!ans.containsKey(sortedWord)) {
                ans.put(sortedWord, new ArrayList<>());
            }

            ans.get(sortedWord).add(word);
        }

        return new ArrayList<>(ans.values());
    }
}