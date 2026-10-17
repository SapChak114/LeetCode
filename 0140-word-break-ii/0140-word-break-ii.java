class Solution {
    Set<String> wordSet;
    String s;
    int n;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordSet = new HashSet<>(wordDict);
        this.s = s;
        this.n = s.length();
        this.res = new ArrayList<>();
        rec(0, new ArrayList<>());
        return res;
    }

    void rec(int idx, List<String> sentence) {
        if (idx == n) {
            res.add(String.join(" ", sentence));
            return;
        }

        for (int i = idx + 1; i<=n; i++) {
            String sub = s.substring(idx, i);

            if (wordSet.contains(sub)) {
                sentence.add(sub);
                rec(i, sentence);
                sentence.remove(sentence.size()-1);
            }
        }
    }
}