class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();
        
        int n = s.length();
        for (int i = 0; i<n; i++) {
            char c = s.charAt(i);
            if (!first.containsKey(c)) {
                first.put(c, i);
            }
            last.put(c, i);
        }

        int count = 0;
        for (char c : first.keySet()) {
            int start = first.get(c);
            int end = last.get(c);

            Set<Character> mid = new HashSet<>();
            for (int i = start+1; i<end; i++) {
                mid.add(s.charAt(i));
            }

            count += mid.size();
        }

        return count;
    }
}