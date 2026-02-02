class Solution {
    String s;
    int n;
    Set<String> words;
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.words = new HashSet<>(wordDict);
        this.ans = new ArrayList<>();
        rec(0, new ArrayList<>());

        return this.ans;
    }

    void rec(int i, List<String> curr) {
        if (i == n) {
            ans.add(String.join(" ", curr));
            return;
        }

        for (int k = i; k<n; k++) {
            String sub = s.substring(i, k+1);
            if (words.contains(sub)) {
                curr.add(sub);
                rec(k+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}