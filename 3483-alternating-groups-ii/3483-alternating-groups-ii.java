class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, count = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i<(n+k-1); i++) {
            int color = colors[i%n];
            if (q.isEmpty()) {
                q.addLast(color);
            } else if ((q.peekLast() ^ 1) == color) {
                q.addLast(color);
            } else {
                q = new ArrayDeque<>();
                q.addLast(color);
            }

            if (q.size() >= k) {
                count++;
            }
        }

        return count;
    }
}