class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String w1 = Arrays.stream(word1).collect(Collectors.joining());
        String w2 = Arrays.stream(word2).collect(Collectors.joining());
        
        return w1.equals(w2);
    }
}