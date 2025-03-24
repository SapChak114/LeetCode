class Solution {
    Map<String, Double> dp;
    public double soupServings(int n) {
        if (n >= 5000) return 1.0;
        n = n / 25 + (n % 25 != 0 ? 1 : 0);
        this.dp = new HashMap<>();

        return dfs(n, n);
    }

    double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }

        if (a <= 0) {
            return 1;
        }

        if (b <= 0) {
            return 0;
        }

        String key = a+"-"+b;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        double val = (0.25 * dfs(a-4, b)) + (0.25 * dfs(a-3, b-1))  + (0.25 * dfs(a-2, b-2)) + (0.25 * dfs(a-1, b-3));

        dp.put(key, val);

        return val;
    }
}