class Solution {
    public int maximumGain(String s, int x, int y) {
        List<Pair<String,Integer>> list = new ArrayList<>();
        list.add(new Pair<>("ab", x));
        list.add(new Pair<>("ba", y));
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        int res = 0;
        for (Pair p : list) {
            String w = (String) p.getKey();
            int val = (int) p.getValue();
            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()) {
                if (!stack.isEmpty() && (stack.peek()+""+c).equals(w)) {
                    stack.pop();
                    res += (int) val;
                } else {
                    stack.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            s = sb.toString();
        }

        return res;
    }
}