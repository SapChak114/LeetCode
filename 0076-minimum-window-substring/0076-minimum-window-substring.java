class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();

        char[] ch = t.toCharArray();

        for (char c : ch) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int need = freq.size();
        int i = 0, j = 0, n = s.length(), size = n, minI = 0, minJ = 0;
        boolean flag = false;

        while (j < n) {
            char endChar = s.charAt(j++);
            if (freq.containsKey(endChar)) {
                freq.put(endChar, freq.get(endChar) - 1);

                if (freq.get(endChar) == 0) {
                    need--;
                }
            }

            if (need > 0) {
                continue;
            }

            while (need == 0) {
                char startChar = s.charAt(i++);

                if (freq.containsKey(startChar)) {
                    freq.put(startChar, freq.get(startChar) + 1);

                    if (freq.get(startChar) > 0) {
                        need++;
                    }
                }
            }

            if (size > j-i) {
                flag = true;
                minI = i;
                minJ = j;
                size = j - i;
            }
        }

        return flag ? s.substring(minI - 1, minJ) : "";
    }
}