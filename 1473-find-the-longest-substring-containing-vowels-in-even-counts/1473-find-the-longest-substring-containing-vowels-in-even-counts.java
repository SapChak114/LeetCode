class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, -1);
        int parity = 0;
        int ans = 0;
        String vowels = "aeiou";

        for (int i = 0; i<n; i++) {
            char c = s.charAt(i);
            if (vowels.contains(c+"")) {
                int idx = vowels.indexOf(c);
                parity ^= 1 << idx;
            }

            if (dp.containsKey(parity)) {
                ans = Math.max(ans, i - dp.get(parity));
            } else {
                dp.put(parity, i);
            }
        }

        return ans;
    }
}