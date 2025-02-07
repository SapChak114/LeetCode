class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorFreq = new HashMap<>();

        int[] res = new int[n];

        for (int i = 0; i<n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor.containsKey(ball)) {
                colorFreq.put(ballColor.get(ball), colorFreq.getOrDefault(ballColor.get(ball), 0) - 1);

                if (colorFreq.get(ballColor.get(ball)) <= 0) {
                    colorFreq.remove(ballColor.get(ball));
                }
            }

            ballColor.put(ball, color);
            colorFreq.put(color, colorFreq.getOrDefault(color, 0) + 1);
            res[i] = colorFreq.size();
        }

        return res;
    }
}