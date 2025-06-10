class Solution {
    public int maxDifference(String s) {
        char[] ch = s.toCharArray();
        int a1 = Integer.MIN_VALUE, a2 = Integer.MAX_VALUE;

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : ch) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count % 2 == 0) {
                a2 = Math.min(a2, count);
            } else {
                a1 = Math.max(a1, count);
            }
        }

        return a1 - a2;
    }
}