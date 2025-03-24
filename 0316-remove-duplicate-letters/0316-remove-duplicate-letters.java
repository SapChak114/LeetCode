class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : ch) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Set<Character> seen = new HashSet<>();
        for (char c : ch) {

            freq.put(c, freq.get(c) - 1);

            if (seen.contains(c)) {
                continue;
            }

            while (!st.isEmpty() && c < st.peek() && freq.get(st.peek()) > 0) {
                seen.remove(st.pop());
            }

            st.push(c);
            seen.add(c);
        }

        List<Character> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        Collections.reverse(ans);

        String res = "";
        for (int i = 0; i<ans.size(); i++) {
            res += ans.get(i);
        }

        return res; 
    }
}