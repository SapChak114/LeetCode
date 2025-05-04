class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {

        Map<String, Integer> counter = new HashMap<>();
        int ans = 0;
        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            String key = Arrays.toString(domino);
            ans += counter.getOrDefault(key, 0);
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }

        return ans;
    }
}