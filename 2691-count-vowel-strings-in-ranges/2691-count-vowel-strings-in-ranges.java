class Solution {
    public int[] vowelStrings(String[] words, int[][] q) {
        int n = words.length;

        List<Integer> pf = new ArrayList<>(Collections.nCopies(n + 1, 0));

        for (int i = 0; i<n; i++) {
            char s = words[i].charAt(0);
            char e = words[i].charAt(words[i].length()-1);

            if (isVowel(s) && isVowel(e)) {
                pf.set(i+1, 1 + pf.get(i));
            } else {
                pf.set(i+1, pf.get(i));
            }
        }

        int[] res = new int[q.length];
        int j = 0;
        for (int[] i : q) {
            int s = i[0];
            int e = i[1];
            res[j++] = pf.get(e+1) - pf.get(s);
        }

        return res;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}