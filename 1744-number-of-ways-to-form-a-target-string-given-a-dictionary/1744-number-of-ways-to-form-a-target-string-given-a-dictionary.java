class Solution {
    int mod = (int) 1e9 + 7;
    Map<Integer, Map<Character, Integer>> counter;
    String[] words;
    String target;
    Integer[][] dp;
    public int numWays(String[] words, String target) {
        this.counter = new HashMap<>();
        this.words = words;
        this.target = target;
        this.dp = new Integer[words[0].length()][target.length()];

        for (int i = 0; i<words[0].length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
            }
            counter.put(i, map);
        }

        return rec(0, 0);
    }

    int rec(int i, int j) {
        if (j == target.length()) {
            return 1;
        }

        if (i >= words[0].length()) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int ways = rec(i + 1, j);

        char c = target.charAt(j);
        int freq = counter.get(i).getOrDefault(c, 0);
        if (freq > 0) {
            ways += (int)((long)freq * rec(i + 1, j + 1) % mod);
            ways %= mod;
        }
        
        return dp[i][j] = ways;
    }
}