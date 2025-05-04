class Solution {
    public String pushDominoes(String domin) {
        Queue<Pair<Character, Integer>> queue = new LinkedList<>();
        char[] dominoes = domin.toCharArray();
        int n = dominoes.length;
        for (int i = 0; i<n; i++) {
            if (dominoes[i] != '.') {
                queue.add(new Pair(dominoes[i], i));
            }
        }
      
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            char domino = (char) p.getKey();
            int index = (int) p.getValue();

            if (domino == 'L' && index > 0 && dominoes[index - 1] == '.') {
                queue.add(new Pair(domino, index - 1));
                dominoes[index -1] = 'L';
            } else if (domino == 'R' && index + 1 < n && dominoes[index + 1] == '.') {
                if (index + 2 < n && dominoes[index + 2] == 'L') {
                    queue.poll();
                } else {
                    queue.add(new Pair('R', index + 1));
                    dominoes[index + 1] = 'R';
                }
            }
        }

        return new String(dominoes);
    }
}