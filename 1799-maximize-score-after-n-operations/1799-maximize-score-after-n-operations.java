class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int terminal_state = (1 << n) - 1;

        Map<Integer, Integer> cache = new HashMap<>();

        return dfs(0, nums, terminal_state, cache);
    }

    private int dfs(int state, int[] nums, int terminal_state, Map<Integer, Integer> cache) {
        if (state == terminal_state) {
            return 0;
        }

        if (cache.containsKey(state)) {
            return cache.get(state);
        }

        int op = Integer.bitCount(state) / 2 + 1;
        int score = 0;

        for (int i = 0; i < nums.length; i++) {
            if (((state >> i) & 1) == 1) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (((state >> j) & 1) == 1) continue;

                int new_state = state | (1 << i) | (1 << j);
                score = Math.max(score,
                        op * gcd(nums[i], nums[j]) +
                                dfs(new_state, nums, terminal_state, cache));
            }
        }

        cache.put(state, score);

        return cache.get(state);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}