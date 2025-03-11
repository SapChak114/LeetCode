class Solution {
    Set<String> set;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {  
        this.set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        queue.add(beginWord);
        levels.add(1);
        Set<String> vis = new HashSet<>();

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int l = levels.poll();
            if (word.equals(endWord)) {
                return l;
            }

            for (String w : getNei(word)) {
                if (!vis.contains(w)) {
                    queue.add(w);
                    levels.add(l + 1);
                    vis.add(w);
                }
            }
        }

        return 0;
    }

    List<String> getNei(String word) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i<word.length(); i++) {
            for (char c = 'a'; c<='z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nWord = word.substring(0, i) + c + word.substring(i+1);
                if (set.contains(nWord)) {
                    list.add(nWord);
                }
            }
        }

        return list;
    }
}