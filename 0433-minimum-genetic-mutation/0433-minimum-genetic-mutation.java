class Solution {
    Set<String> wordSet;
    public int minMutation(String startGene, String endGene, String[] bank) {
        this.wordSet = new HashSet<>();

        for (String b : bank) {
            this.wordSet.add(b);
        }

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(startGene);
        levels.add(0);

        Set<String> vis = new HashSet<>();
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = levels.poll();
            if (endGene.equals(word)) {
                return level;
            }

            for (String s : getNei(word)) {
                if (!vis.contains(s)) {
                    queue.add(s);
                    levels.add(level + 1);
                    vis.add(s);
                }
            }
        }

        return -1;
    }

    List<String> getNei(String word) {
        List<String> wordList = new ArrayList<>();

        for (int i = 0; i<word.length(); i++) {
            for (char c = 'A'; c<='Z'; c++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                String nWord = word.substring(0, i) + c + word.substring(i + 1);
                if (wordSet.contains(nWord)) {
                    wordList.add(nWord);
                }
            }
        }

        return wordList;
    }
}