class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(board);

        for(String word : words){
            trie.insert(word);
        }

        return trie.findAll();
    }
}

class TrieNode{
    Map<Character,TrieNode> hm = new HashMap<>();
    boolean isEnd;
}

class Trie{
    TrieNode root;
    char[][] b;
    List<String> ans;
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};

    public Trie(char[][] b){
        this.b = b;
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.hm.containsKey(c)){
                curr.hm.put(c, new TrieNode());
            }
            curr = curr.hm.get(c);
        }
        curr.isEnd = true;
    }

    public List<String> findAll(){
        TrieNode curr = root;
        int n = b.length, m = b[0].length;
        this.ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                char c = b[i][j];
                if(curr.hm.containsKey(c)){
                    dfs(curr.hm.get(c),i,j,b,""+c);
                }
            }
        }
        return this.ans;
    }

    void dfs(TrieNode node, int x, int y, char[][] b, String word){
        if(node.isEnd && !word.isEmpty()){
            node.isEnd = false;
            ans.add(word);
        }

        char c = b[x][y];
        b[x][y] = '*';

        for(int i = 0; i<dirX.length; i++){
            int newX = dirX[i] + x;
            int newY = dirY[i] + y;
            if(check(newX, newY)){
                char ch = b[newX][newY];
                if(node.hm.containsKey(ch)){
                    dfs(node.hm.get(ch), newX, newY, b, word+b[newX][newY]);
                }
            }
        }

        b[x][y] = c;
    }

    boolean check(int x, int y){
        int n = b.length, m = b[0].length;
        if(x<0 || x>=n || y<0 || y>=m){
            return false;
        }
        return true;
    }
}