class Solution {
    private int[] dirX = {0, 1, 0, -1};
    private int[] dirY = {1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int n = board.length;
        int m = board[0].length;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char letter = board[i][j];
        int index = letter - 'a';

        if (letter == '#' || node.children[index] == null) {
            return;
        }

        node = node.children[index];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        // Mark the cell as visited
        char tmp = board[i][j];
        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int r = i + dirX[k];
            int c = j + dirY[k];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                dfs(board, r, c, node, result);
            }
        }

        // Restore the cell
        board[i][j] = tmp;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
    }
}
