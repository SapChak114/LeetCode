class Solution {
    int mod = (int)1e9 + 7;
    Map<String, Integer> dp;
    public int numberOfWays(int startPos, int endPos, int k) {
        this.dp = new HashMap<>();
        return find(startPos, endPos, k);
    }

    int find(int s, int e, int k) {
        if (k == 0) {
            if (s == e) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = s + "-" + k;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }


        int left = find(s - 1, e, k - 1);
        int right = find(s + 1, e, k - 1);

        int value = (left + right) % mod;

        dp.put(key, value);

        return value;
    }
}