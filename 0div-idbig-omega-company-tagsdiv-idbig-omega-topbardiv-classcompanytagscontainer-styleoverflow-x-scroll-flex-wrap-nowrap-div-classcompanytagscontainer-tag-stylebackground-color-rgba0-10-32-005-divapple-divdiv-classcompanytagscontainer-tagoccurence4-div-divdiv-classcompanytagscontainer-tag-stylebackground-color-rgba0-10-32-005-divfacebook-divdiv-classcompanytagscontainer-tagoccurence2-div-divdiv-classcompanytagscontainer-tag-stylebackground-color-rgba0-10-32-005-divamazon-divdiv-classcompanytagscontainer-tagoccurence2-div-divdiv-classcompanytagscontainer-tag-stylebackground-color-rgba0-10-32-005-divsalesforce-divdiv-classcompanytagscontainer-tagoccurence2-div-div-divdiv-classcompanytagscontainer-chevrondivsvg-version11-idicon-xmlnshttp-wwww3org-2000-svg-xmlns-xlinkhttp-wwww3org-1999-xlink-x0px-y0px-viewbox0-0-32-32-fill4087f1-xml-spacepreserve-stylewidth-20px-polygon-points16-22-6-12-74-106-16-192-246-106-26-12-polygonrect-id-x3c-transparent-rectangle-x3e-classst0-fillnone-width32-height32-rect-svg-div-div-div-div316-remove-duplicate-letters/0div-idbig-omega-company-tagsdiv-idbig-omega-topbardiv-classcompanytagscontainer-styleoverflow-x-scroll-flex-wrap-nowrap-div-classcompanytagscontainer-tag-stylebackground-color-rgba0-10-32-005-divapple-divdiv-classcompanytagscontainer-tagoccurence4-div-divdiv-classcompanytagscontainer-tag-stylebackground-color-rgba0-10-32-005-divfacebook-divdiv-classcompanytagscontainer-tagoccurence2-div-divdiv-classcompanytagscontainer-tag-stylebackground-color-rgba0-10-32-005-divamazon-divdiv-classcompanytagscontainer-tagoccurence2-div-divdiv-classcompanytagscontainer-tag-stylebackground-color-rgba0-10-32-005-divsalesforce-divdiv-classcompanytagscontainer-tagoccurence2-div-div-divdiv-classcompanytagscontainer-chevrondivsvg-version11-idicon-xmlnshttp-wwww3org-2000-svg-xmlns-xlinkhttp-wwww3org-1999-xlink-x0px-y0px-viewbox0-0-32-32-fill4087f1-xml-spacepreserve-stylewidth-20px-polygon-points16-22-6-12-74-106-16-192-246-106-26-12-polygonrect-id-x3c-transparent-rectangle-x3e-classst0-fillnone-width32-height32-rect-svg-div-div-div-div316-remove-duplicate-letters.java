class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] lastIndex = new int[26];
        int[] seen = new int[26];
        for(int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i) - 'a'] = i;

        for(int i = 0; i < s.length(); i++){
            int charValue = s.charAt(i) - 'a';
            if(seen[charValue]++ > 0) continue;
            while(!stack.isEmpty() && charValue < stack.peek() && i < lastIndex[stack.peek()])
                seen[stack.pop()] = 0;
            stack.push(charValue);
        }
        StringBuilder ans = new StringBuilder();
        for (int i : stack) ans.append((char)('a' + i));
        return ans.toString();
    }
}