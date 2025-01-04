class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] ch = s.toCharArray();

        Map<Character, Integer> right = new HashMap<>();
        for (char c : ch) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }

        Set<Character> left = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int i = 0; i<ch.length; i++) {
            char mid = ch[i];
            right.put(mid, right.getOrDefault(mid, 0) - 1);
            if (right.get(mid) == 0) {
                right.remove(mid);
            }

            for (char chr = 'a'; chr<='z'; chr++) {
                if (left.contains(chr) && right.containsKey(chr)) {
                    res.add((chr+""+mid+""+chr));
                }
            }
            left.add(mid);
        }

        return res.size();
    }
}