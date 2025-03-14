class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[n + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();

            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= n; end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    seen[end] = true;
                    queue.add(end);
                }
            }
        }

        return false;
    }
}