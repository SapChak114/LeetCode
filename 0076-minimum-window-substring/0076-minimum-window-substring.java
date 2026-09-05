class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int need = freq.size();
        int i = 0, j = 0, minI = 0, minJ = 0, n = s.length(), size = n;
        boolean found = false;

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
                minI = i;
                minJ = j;
                size = j-i;
                found = true;
            }
        }

        return found ? s.substring(minI-1, minJ) : "";
    }
}