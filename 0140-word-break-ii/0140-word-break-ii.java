class Solution {
    String s;
    int n;
    Set<String> wordSet;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.wordSet = new HashSet<>(wordDict);
        this.res = new ArrayList<>();
        rec(0, new ArrayList<>());
        return res;
    }

    void rec(int idx, List<String> lis) {
        if (idx == n) {
            res.add(String.join(" ",lis));
            return;
        }

        for (int i = idx + 1; i<=n; i++) {
            String w = s.substring(idx, i);

            if (wordSet.contains(w)) {
                lis.add(w);
                rec(i, lis);
                lis.remove(lis.size()-1);
            }
        }
    }
}