class Solution {
    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(beginWord);
        levels.add(1);
        vis.add(beginWord);

        while (!q.isEmpty()) {
            String word = q.poll();
            int level = levels.poll();

            if (word.equals(endWord)) {
                return level;
            }

            for (String nei : getNei(word)) {
                if (!vis.contains(nei)) {
                    q.add(nei);
                    levels.add(level+1);
                    vis.add(nei);
                }
            }
        }

        return 0;
    }

    List<String> getNei(String word) {
        int n = word.length();
        List<String> words = new ArrayList<>();
        
        for (int i = 0; i<n; i++) {
            for (char ch = 'a'; ch<='z'; ch++) {
                String newWord = word.substring(0, i) + ch + word.substring(i+1);
                if (newWord.equals(word) || !wordSet.contains(newWord)) {
                    continue;
                }
                words.add(newWord);
            }
        }

        return words;
    }
}