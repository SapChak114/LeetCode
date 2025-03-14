class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        char[] ch = s.toCharArray();
        int n = words.length;
        int ans = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0)+1);
        }


        for (String word : map.keySet()) {
            char[] ch2 = word.toCharArray();

            int j = 0;
            for (int i = 0; i<ch.length; i++) {
                if (j < ch2.length && ch[i] == ch2[j]) {
                    j++;
                }
            }

            if (j == ch2.length) {
                ans += map.getOrDefault(word, 0);
            }
        }

        return ans;
    }
}