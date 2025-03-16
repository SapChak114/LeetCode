class Solution {
    public String longestWord(String[] words) {
        int n = 0;
        Set<String> wordSet = new HashSet<>();

        for (String w : words) {
            wordSet.add(w);
        }

        Arrays.sort(words, (a, b) -> b.length() == a.length() ? a.compareTo(b) : b.length()-a.length());
        System.out.println(Arrays.toString(words));

        for (String w : words) {
            for (int i = 0; i<w.length(); i++) {
                if (!wordSet.contains(w.substring(0, i+1))) {
                    break;
                } else if(i == w.length()-1) {
                    return w;
                }
            }
        }

        return "";
    }
}