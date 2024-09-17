class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> li = uncommonFromSentence(s1, s2);
        String[] ans = new String[li.size()];
        int i = 0;
        for (String s : li) {
            ans[i++] = s;
        }

        return ans;
    }

    public List<String> uncommonFromSentence(String s1, String s2) {
        // Concatenate both sentences with a space
        String s = s1 + " " + s2;
        
        // Create a map to store the word counts
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Split the combined string into words
        String[] words = s.split(" ");
        
        // Count the occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Create a list to store the uncommon words (those with a count of 1)
        List<String> result = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
}