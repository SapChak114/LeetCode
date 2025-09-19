class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        Map<Character, Integer> lastOcc = new HashMap<>();

        for (int i = 0; i<ch.length; i++) {
            lastOcc.put(ch[i], i);
        }

        Set<Character> seen = new HashSet<>();
        for (int i = 0; i<ch.length; i++) {
            char c = ch[i];

            if (seen.contains(c)) {
                continue;
            }

            while (!st.isEmpty() && c < st.peek() && lastOcc.get(st.peek()) > i) {
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