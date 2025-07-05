class Solution {
    public char kthCharacter(int k) {
        List<Character> s = new ArrayList<>();
        s.add('a');

        while (s.size() < k) {
            int n = s.size();
            for (int i = 0; i<n; i++) {
                char ch = s.get(i) == 'z' ? 'a' : (char)(s.get(i) + 1);
                s.add(ch);
            }
        }

        return s.get(k-1);
    }
}