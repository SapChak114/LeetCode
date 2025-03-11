class Solution {
    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.wordSet = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        Set<String> vis = new HashSet<>();

        queue.add(beginWord);
        levels.add(1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = levels.poll();
            if (word.equals(endWord)) {
                return level;
            }

            for (String w : getNei(word)) {
                if (!vis.contains(w)) {
                    queue.add(w);
                    levels.add(level+1);
                    vis.add(w);
                }
            }
        }

        return 0;
    }

    List<String> getNei(String word) {
        List<String> wordList = new ArrayList<>();

        for (int i = 0; i<word.length(); i++) {
            for (char c = 'a'; c<='z'; c++) {
                String nWord = word.substring(0, i) + c + word.substring(i+1);
                if (word.charAt(i) == c) {
                    continue;
                }
                if (wordSet.contains(nWord)) {
                    wordList.add(nWord);
                }
            }
        }

        return wordList;
    }
}