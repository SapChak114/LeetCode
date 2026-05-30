class Solution {
    Set<String> wordSet;
    List<String> ans;
    int n;
    String s;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.wordSet = new HashSet<>(wordDict);
        this.ans = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return this.ans;
    }

    void dfs(int i, List<String> sentence) {
        if (i == n) {
            ans.add(String.join(" ", sentence));
            return;
        }

        for (int a = i+1; a<=n; a++) {
            String newWord = s.substring(i, a);
            if (wordSet.contains(newWord)) {
                sentence.add(newWord);
                dfs(a, sentence);
                sentence.remove(sentence.size()-1);
            }
        }
    }
}