class Solution {
    public int nextBeautifulNumber(int n) {
        int i = n + 1;

        while (true) {
            if (isBeautiful(i)) {
                return i;
            }
            i++;
        }
    }

    boolean isBeautiful(int x) {
        String s = Integer.toString(x);

        Map<Character, Integer> fq = new HashMap<>();

        for (char c : s.toCharArray()) {
            fq.put(c, fq.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (fq.get(c) != (c-'0')) {
                return false;
            }
        }

        return true;
    }
}