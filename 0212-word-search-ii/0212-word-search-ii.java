class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(board);

        for (String w : words) {
            trie.insert(w);
        }

        return trie.findAll();
    }
}

class TrieNode{
    Map<Character, TrieNode> hm = new HashMap<>();
    boolean isEnd;
}

class Trie{
    TrieNode trie;
    char[][] board;
    List<String> ans;
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};

    public Trie(char[][] board) {
        this.board = board;
        this.trie = new TrieNode();
    }

    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode node = this.trie;
        for (char c : chs) {
            if (!node.hm.containsKey(c)) {
                node.hm.put(c, new TrieNode());
            }
            node = node.hm.get(c);

        }
        node.isEnd = true;
    }

    public List<String> findAll() {
        this.ans = new ArrayList<>();
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[i].length; j++) {
                char c = board[i][j];
                if (trie.hm.containsKey(c)) {
                    dfs(trie.hm.get(c), board, i, j, ""+c);
                }
            }
        }
        return this.ans;
    }

    void dfs(TrieNode trie, char[][] board, int x, int y, String word) {
        if (trie.isEnd && !word.isEmpty()) {
            ans.add(word);
            trie.isEnd = false;
        }

        char c = board[x][y];
        board[x][y] = '*';

        for (int i = 0; i<dirX.length; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];

            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                continue;
            }

            char ch = board[newX][newY];
            if (trie.hm.containsKey(ch)) {
                dfs(trie.hm.get(ch), board, newX, newY, word + ch);
            }
        }

        board[x][y] = c;
    }
}