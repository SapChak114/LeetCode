class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = brokenLetters.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.toSet());
        
        String[] words = text.split(" ");

        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (set.contains(c)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }
}