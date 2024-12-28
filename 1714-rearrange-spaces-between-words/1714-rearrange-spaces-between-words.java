class Solution {
    public String reorderSpaces(String text) {
        int spaces = (int) text.chars().filter(ch -> ch == ' ').count();
        String[] words = text.trim().split("\\s+");
        int n = words.length;
        if (n == 1 && spaces == 0) {
            return text;
        }
        int equalSpaces = n > 1 ? (spaces / (n - 1)) : 0;
        int extraSpaces = 0;
        
        if (equalSpaces * (n - 1) != spaces) {
            extraSpaces = Math.abs((equalSpaces * (n - 1)) - spaces);
        }
        //System.out.println("spaces "+spaces+" equalSpaces: "+equalSpaces+" extraSpaces: "+extraSpaces+" words: "+n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            sb.append(words[i]);
            if (i != n-1) {
                sb.append(" ".repeat(equalSpaces));
            }
        }

        if (extraSpaces != 0) {
            sb.append(" ".repeat(extraSpaces));
        }

        return sb.toString();
    }

}