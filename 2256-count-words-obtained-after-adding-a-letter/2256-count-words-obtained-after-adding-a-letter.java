class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> sortedStartWord = new HashSet<>();
        for (String start : startWords) {
            char[] ch = start.toCharArray();
            Arrays.sort(ch);
            sortedStartWord.add(new String(ch));
        }

        int count = 0;
        for (String targ : targetWords) {
            char[] ch = targ.toCharArray();
            Arrays.sort(ch);
            String sortedTarg = new String(ch);
            int n = sortedTarg.length();
            for (int i = 0; i<n; i++) {
                String sub = sortedTarg.substring(0, i) + sortedTarg.substring(i+1);
                if (sortedStartWord.contains(sub)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}