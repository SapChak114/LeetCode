class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] vis = new boolean[s.length()+1];
        vis[0] = true;

        while (!q.isEmpty()) {
            int start = q.poll();
            if (start == s.length()) {
                return true;
            }
            for (int i = start+1; i<=s.length(); i++) {
                if (vis[i]) {
                    continue;
                }
                String word = s.substring(start, i);
                if (wordDict.contains(word)) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }

        return false;
    }
}