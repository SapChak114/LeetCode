class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        
        List<Character> vowels = new ArrayList<>();
        for (int i = 0; i<ch.length; i++) {
            if (isVowel(ch[i])) {
                vowels.add(ch[i]);
                ch[i] = '*';
            }
        }

        //System.out.println(Arrays.toString(ch));        
        int j = 0;
        for (int i = ch.length - 1; i>=0; i--) {
            if (ch[i] == '*') {
                ch[i] = vowels.get(j++);
            }
        }

        return new String(ch);
        
    }

    boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}