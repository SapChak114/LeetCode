class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int pos = 0;

        while (pos < word.length()) {
            int count = 0;
            char currentChar = word.charAt(pos);

            while (pos < word.length() && count < 9 
            && word.charAt(pos) == currentChar) {
                pos++;
                count++;
            }

            sb.append(count).append(currentChar);
        }

        return sb.toString();
    }
}