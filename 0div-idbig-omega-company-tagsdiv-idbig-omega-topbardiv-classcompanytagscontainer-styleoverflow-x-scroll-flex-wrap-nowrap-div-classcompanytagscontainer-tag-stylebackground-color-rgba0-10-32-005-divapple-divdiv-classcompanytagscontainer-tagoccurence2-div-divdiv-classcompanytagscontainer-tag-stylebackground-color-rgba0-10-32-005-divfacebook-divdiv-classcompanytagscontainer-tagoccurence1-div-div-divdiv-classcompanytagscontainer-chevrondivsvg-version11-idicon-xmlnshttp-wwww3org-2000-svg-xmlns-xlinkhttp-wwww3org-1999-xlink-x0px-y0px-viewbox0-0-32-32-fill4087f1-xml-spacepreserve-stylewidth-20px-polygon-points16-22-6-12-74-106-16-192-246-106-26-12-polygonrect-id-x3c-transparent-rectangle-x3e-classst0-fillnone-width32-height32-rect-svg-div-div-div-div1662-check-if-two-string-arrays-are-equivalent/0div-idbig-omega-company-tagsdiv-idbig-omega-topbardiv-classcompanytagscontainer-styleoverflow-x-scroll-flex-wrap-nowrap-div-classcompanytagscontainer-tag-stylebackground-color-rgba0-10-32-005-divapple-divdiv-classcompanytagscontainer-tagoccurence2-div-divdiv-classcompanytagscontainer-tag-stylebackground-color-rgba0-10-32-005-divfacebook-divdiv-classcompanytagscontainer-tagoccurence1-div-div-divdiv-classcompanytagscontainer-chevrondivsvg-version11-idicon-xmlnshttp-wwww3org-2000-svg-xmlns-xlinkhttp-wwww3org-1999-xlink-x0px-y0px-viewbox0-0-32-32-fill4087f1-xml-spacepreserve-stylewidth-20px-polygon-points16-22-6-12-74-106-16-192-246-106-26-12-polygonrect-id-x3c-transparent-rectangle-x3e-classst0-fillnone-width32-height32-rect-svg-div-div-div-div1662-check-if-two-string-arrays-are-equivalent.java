class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        Set<String> res = new HashSet<>();
        int n = word1.length;
        int m = word2.length;
        
        String w1 = "";
        for(int i = 0; i<n; i++){
           w1 = w1 + word1[i];
        }
        
        String w2 = "";
        for(int i = 0; i<m; i++){
           w2 = w2 + word2[i];
        }
        
        
        return w1.equals(w2);
    }
}