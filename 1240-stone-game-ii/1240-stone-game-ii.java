class Solution {
    private static final int ALICE = 0;
    private static final int BOB = 1;

    private int[] prefixSum;
    private int[][][] memo;

    public int stoneGameII(int[] A) {
        int n = A.length;
        prefixSum = new int[n + 1];
        memo = new int[n][n + 1][2];

        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        // Map ALICE to Math::max and BOB to Math::min
        Map<Integer, BiFunction<Integer, Integer, Integer>> mp = new HashMap<>();
        mp.put(ALICE, Math::max);
        mp.put(BOB, Math::min);

        return dfs(0, 1, ALICE, A, mp);
    }

    private int dfs(int index, int m, int turn, int[] A, Map<Integer, BiFunction<Integer, Integer, Integer>> mp) {
        if (index >= A.length) {
            return 0;
        }

        if (memo[index][m][turn] != -1) {
            return memo[index][m][turn];
        }

        int result = (turn == ALICE) ? 0 : Integer.MAX_VALUE;

        for (int x = 1; x <= 2 * m; x++) {
            int nIndex = Math.min(index + x, A.length);
            int total = prefixSum[nIndex] - prefixSum[index];
            if (turn == BOB) {
                total = 0;
            }
            result = mp.get(turn).apply(result, total + dfs(nIndex, Math.max(m, x), turn ^ 1, A, mp));
        }

        memo[index][m][turn] = result;
        return result;
    }
}